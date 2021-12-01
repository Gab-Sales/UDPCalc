package com.mycompany.udpcalc;

/**
 *
 * @author Gabriel
 */
public class CalcForms {
    int pos;
    
    public CalcForms(){
        this.pos = 1;
    }
    
    public String calculate (String array[]){
        if(pos<array.length){
            if(array[pos].equals("*")){
                pos = pos-1;
                String left = calculate(array);
                pos = pos+2;
                String rigth = calculate(array);
                return ""+ (Double.parseDouble(left)* Double.parseDouble(rigth));
            }
            else if(array[pos].equals("-")){
                pos = pos-1;
                String left = calculate(array);
                pos = pos+2;
                String rigth = calculate(array);
                return ""+ (Double.parseDouble(left) - Double.parseDouble(rigth));
            }
            else if(array[pos].equals("+")){
                pos = pos-1;
                String left = calculate(array);
                pos = pos+2;
                String rigth = calculate(array);
                return ""+ (Double.parseDouble(left)+ Double.parseDouble(rigth));
            }
            else if(array[pos].equals("/")){
                pos = pos-1;
                String left = calculate(array);
                pos = pos+2;
                String rigth = calculate(array);
                if(!rigth.equals("0")){
                    return ""+ (Double.parseDouble(left)/Double.parseDouble(rigth));    
                }
                else{
                    return "error: division by 0";
                }
            }
            else{
                return array[pos].trim();
            }
        }
        return "";
    }
}
