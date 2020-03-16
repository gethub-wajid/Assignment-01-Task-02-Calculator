package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manageClicks();
    }
    private void manageClicks(){
        findViewById(R.id.tv_00).setOnClickListener(appListener);
        findViewById(R.id.tv_0).setOnClickListener(appListener);
        findViewById(R.id.tv_1).setOnClickListener(appListener);
        findViewById(R.id.tv_2).setOnClickListener(appListener);
        findViewById(R.id.tv_3).setOnClickListener(appListener);
        findViewById(R.id.tv_4).setOnClickListener(appListener);
        findViewById(R.id.tv_5).setOnClickListener(appListener);
        findViewById(R.id.tv_6).setOnClickListener(appListener);
        findViewById(R.id.tv_7).setOnClickListener(appListener);
        findViewById(R.id.tv_8).setOnClickListener(appListener);
        findViewById(R.id.tv_9).setOnClickListener(appListener);
        findViewById(R.id.tv_add).setOnClickListener(appListener);
        findViewById(R.id.tv_sub).setOnClickListener(appListener);
        findViewById(R.id.tv_div).setOnClickListener(appListener);
        findViewById(R.id.tv_mul).setOnClickListener(appListener);
        findViewById(R.id.tv_mod).setOnClickListener(appListener);
        findViewById(R.id.tv_ac).setOnClickListener(appListener);
        findViewById(R.id.tv_del).setOnClickListener(appListener);
        findViewById(R.id.tv_dot).setOnClickListener(appListener);
        findViewById(R.id.tv_equal).setOnClickListener(appListener);
    }
    private View.OnClickListener appListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView screen = findViewById(R.id.tv_equation);
            TextView answer = findViewById(R.id.tv_result);
            if(v.getId() == R.id.tv_00){
                if(screen.getText().toString() != "0"){
                    screen.setText(screen.getText().toString() + "00");
                }
            }
            else if(v.getId() == R.id.tv_0){
                if(screen.getText().toString() != "0"){
                    screen.setText(screen.getText().toString() + "0");
                }
            }
            else if(v.getId() == R.id.tv_1){
                screen.setText(screen.getText().toString() + "1");
            }
            else if(v.getId() == R.id.tv_2){
                screen.setText(screen.getText().toString() + "2");
            }
            else if(v.getId() == R.id.tv_3){
                screen.setText(screen.getText().toString() + "3");
            }
            else if(v.getId() == R.id.tv_4){
                screen.setText(screen.getText().toString() + "4");
            }
            else if(v.getId() == R.id.tv_5){
                screen.setText(screen.getText().toString() + "5");
            }
            else if(v.getId() == R.id.tv_6){
                screen.setText(screen.getText().toString() + "6");
            }
            else if(v.getId() == R.id.tv_7){
                screen.setText(screen.getText().toString() + "7");
            }
            else if(v.getId() == R.id.tv_8){
                screen.setText(screen.getText().toString() + "8");
            }
            else if(v.getId() == R.id.tv_9){
                screen.setText(screen.getText().toString() + "9");
            }
            else if(v.getId() == R.id.tv_add){
                String curStr = screen.getText().toString();
                if(curStr.length() != 0) {
                    char last = curStr.charAt(curStr.length() - 1);
                    if(last != '+' && last != '.'){
                        if(last == '/' || last == '*' || last == '-' || last == '%'){
                            int len = curStr.length();
                            String newStr = curStr.substring(0,len-1);
                            screen.setText(newStr+"+");
                        }
                        else{
                            screen.setText(screen.getText().toString() + "+");
                        }
                    }
                }
            }
            else if(v.getId() == R.id.tv_sub){
                String curStr = screen.getText().toString();
                if(curStr.length() != 0) {
                    char last = curStr.charAt(curStr.length() - 1);
                    if(last != '-' && last != '.'){
                        if(last == '/' || last == '*' || last == '+' || last == '%'){
                            int len = curStr.length();
                            String newStr = curStr.substring(0,len-1);
                            screen.setText(newStr+"-");
                        }
                        else{
                            screen.setText(screen.getText().toString() + "-");
                        }
                    }
                }
            }
            else if(v.getId() == R.id.tv_div){
                String curStr = screen.getText().toString();
                if(curStr.length() != 0) {
                    char last = curStr.charAt(curStr.length() - 1);
                    if(last != '/' && last != '.'){
                        if(last == '+' || last == '*' || last == '-' || last == '%'){
                            int len = curStr.length();
                            String newStr = curStr.substring(0,len-1);
                            screen.setText(newStr+"/");
                        }
                        else{
                            screen.setText(screen.getText().toString() + "/");
                        }
                    }
                }
            }
            else if(v.getId() == R.id.tv_mul){
                String curStr = screen.getText().toString();
                if(curStr.length() != 0) {
                    char last = curStr.charAt(curStr.length() - 1);
                    if(last != '*' && last != '.'){
                        if(last == '/' || last == '+' || last == '-' || last == '%'){
                            int len = curStr.length();
                            String newStr = curStr.substring(0,len-1);
                            screen.setText(newStr+"*");
                        }
                        else{
                            screen.setText(screen.getText().toString() + "*");
                        }
                    }
                }
            }
            else if(v.getId() == R.id.tv_mod){
                String curStr = screen.getText().toString();
                if(curStr.length() != 0) {
                    char last = curStr.charAt(curStr.length() - 1);
                    if(last != '%' && last != '.'){
                        if(last == '/' || last == '*' || last == '-' || last == '+'){
                            int len = curStr.length();
                            String newStr = curStr.substring(0,len-1);
                            screen.setText(newStr+"%");
                        }
                        else{
                            screen.setText(screen.getText().toString() + "%");
                        }
                    }
                }
            }
            else if(v.getId() == R.id.tv_ac){
                screen.setText("");
                answer.setText("");
            }
            else if(v.getId() == R.id.tv_del){
                if(screen.getText().toString().length() != 0){
                    String prevScreen = screen.getText().toString();
                    int len = prevScreen.length();
                    String newStr = prevScreen.substring(0,len-1);
                    screen.setText(newStr);
                }
            }
            else if(v.getId() == R.id.tv_dot){
                String curStr = screen.getText().toString();
                boolean isPresent = false;
                for(int i = 0; (i < curStr.length()); i++){
                    if(curStr.charAt(i) == '.'){
                        isPresent = true;
                    }
                    if(curStr.charAt(i) == '%' || curStr.charAt(i) == '/' ||
                       curStr.charAt(i) == '*' || curStr.charAt(i) == '+' ||
                       curStr.charAt(i) == '-'){
                       isPresent = false;
                    }
                }
                if(!isPresent){
                    if(curStr.length() != 0) {
                        char last = curStr.charAt(curStr.length() - 1);
                        if(last != '/' && last != '*' && last != '-' && last != '+' && last != '%'){
                            if(last != '.'){
                                screen.setText(screen.getText().toString() + ".");
                            }
                        }
                        else{
                            screen.setText(screen.getText().toString() + "0.");
                        }
                    }
                    else{
                        screen.setText("0.");
                    }
                }
            }
            else if(v.getId() == R.id.tv_equal){
                float ans = evaluate(screen.getText().toString());
                answer.setText(ans+"");
            }
        }
    };
    private float evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
        // Stack for numbers: 'values'
        Stack<Float> values = new Stack<Float>();
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                sbuf.append(tokens[i]);
                // There may be more than one digits in number
                while (i+1 < tokens.length && (tokens[i+1] >= '0' && tokens[i+1] <= '9')||
                              tokens[i] == '.') {
                    sbuf.append(tokens[i++]);
                }
                values.push(Float.parseFloat(sbuf.toString()));
            }
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '%')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())){
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }
        }
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty()){
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    private boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '%')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    private float applyOp(char op, float b, float a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '%':
                return a % b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
