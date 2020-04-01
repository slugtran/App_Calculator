
package vn.edu.hust.edu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public ArrayList<String> tem = new ArrayList<>();
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7,
            btn8, btn9, btnAdd, btnSub, btnDiv, btnMul, btnResult,
            btnC, btnCE, btnBS, btnDot, btnDoiDau;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface tvFont = Typeface.createFromAsset(getAssets(), "fonts/DS-DIGIT.TTF");
        tv1 = findViewById(R.id.tv1);
        tv1.setTypeface(tvFont);
        tv2 = findViewById(R.id.tv2);
        tv2.setTypeface(tvFont);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn0).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
        findViewById(R.id.btn6).setOnClickListener(this);
        findViewById(R.id.btn7).setOnClickListener(this);
        findViewById(R.id.btn8).setOnClickListener(this);
        findViewById(R.id.btn9).setOnClickListener(this);

        findViewById(R.id.btnAdd).setOnClickListener(this);
        findViewById(R.id.btnSub).setOnClickListener(this);
        findViewById(R.id.btnMul).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
        findViewById(R.id.btnC).setOnClickListener(this);
        findViewById(R.id.btnCE).setOnClickListener(this);
        findViewById(R.id.btnBS).setOnClickListener(this);
        findViewById(R.id.btnDot).setOnClickListener(this);
        findViewById(R.id.btnDoiDau).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn0:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("0");
                break;
            case R.id.btn1:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("1");
                break;
            case R.id.btn2:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("2");
                break;
            case R.id.btn3:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("3");
                break;
            case R.id.btn4:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("4");
                break;
            case R.id.btn5:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("5");
                break;
            case R.id.btn6:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("6");
                break;
            case R.id.btn7:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("7");
                break;
            case R.id.btn8:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("8");
                break;
            case R.id.btn9:
                if (Integer.parseInt(tv2.getText().toString()) == 0)
                    tv2.setText("");
                tv2.append("9");
                break;
            case R.id.btnCE:
                tv2.setText("0");
                break;
            case R.id.btnC:
                tv1.setText("");
                tv2.setText("0");
                break;
            case R.id.btnBS:
                String numberAfterBS = deleteANumber(tv2.getText().toString());
                if (numberAfterBS.length() == 0) tv2.setText("0");
                else tv2.setText(numberAfterBS);
                break;
            case R.id.btnDiv:
                if (tv1.getText() != ""){
                    String numberAfter = deleteANumber(tv1.getText().toString());
                    tv1.setText(numberAfter);
                } else  {
                    tv1.append(tv2.getText());
                }
                tv1.append("/");
                tv2.setText("0");
                break;
            case R.id.btnMul:
                if (tv1.getText() != ""){
                    String numberAfter = deleteANumber(tv1.getText().toString());
                    tv1.setText(numberAfter);
                } else  {
                    tv1.append(tv2.getText());
                }
                tv1.append("x");
                tv2.setText("0");
                break;
            case R.id.btnSub:
                if (tv1.getText() != ""){
                    String numberAfter = deleteANumber(tv1.getText().toString());
                    tv1.setText(numberAfter);
                } else  {
                    tv1.append(tv2.getText());
                }
                tv1.append("-");
                tv2.setText("0");
                break;
            case R.id.btnAdd:
                if (tv1.getText() != ""){
                    String numberAfter = deleteANumber(tv1.getText().toString());
                    tv1.setText(numberAfter);
                } else  {
                    tv1.append(tv2.getText());
                }
                tv1.append("+");
                tv2.setText("0");
                break;
            case R.id.btnDoiDau:
                tv1.append(tv2.getText());
                tv1.append("");
                tv2.setText("0");
                break;
            case R.id.btnDot:
                //tv1.append(".");
                break;
            case R.id.btnResult:
                int result = 0;
                tv1.append(tv2.getText());
                int x = output(tv1.getText().toString(), tv1.getText().toString());
                tv1.append("=");
                tv2.setText(x + "");
                break;
        }
    }
    public  String deleteANumber(String number)  {
        int length = number.length();
        String tmp = number.substring(0, length - 1);
        return tmp;
    }
    //save operations
    public ArrayList<String> arrOperation;

    public void addOperration(String input)  {
        arrOperation = new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i = 0; i < cArray.length; i++)  {
            switch (cArray[i])  {
                case '+' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x' :
                    arrOperation.add(cArray[i] + "");
                    break;
                case '/' :
                    arrOperation.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
    }
    //save number
    public  ArrayList<Double> arrNumber;
    public void addNumber(String stringInput)  {
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while (matcher.find())  {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
    // output()
    public int output(String a, String b)  {
        addNumber(a);
        addOperration(b);
        int result = 0;
        for (int i = 0; i < arrNumber.size() - 1; i++)  {
            switch (arrOperation.get(i))  {
                case "+" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) + arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result + arrNumber.get(i + 1));
                    }
                    break;
                case "-" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) - arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result - arrNumber.get(i + 1));
                    }
                    break;
                case "x" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) * arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result * arrNumber.get(i + 1));
                    }
                    break;
                case "/" :
                    if (i == 0)  {
                        result = (int) (arrNumber.get(i) / arrNumber.get(i + 1));
                    } else  {
                        result = (int) (result / arrNumber.get(i + 1));
                    }
                    break;
            }
        }
        return result;
    }
}

