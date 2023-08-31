package calc;

public class calc {
    
    public static double calc(boolean avgEditable, double avgValue, boolean[] grdEditable, double[] grdValues, double[] percent){
        double res = 0;
        if (avgEditable){
            double remainingPercent = 0;
            double currentGrade = 0;
            for (int i = 0; i < grdEditable.length; i++){
                if (grdEditable[i] == true){
                    currentGrade += grdValues[i]*percent[i]/100;
                }else{
                    remainingPercent += percent[i]/100;
                }
            }
            res = (avgValue - currentGrade)/remainingPercent;
            return res;
        }else{
            /*
            for (int i = 0; i < grdValues.length; i++){
                res += grdValues[i]*percent[i]/100;
            }
            return res;
            */
            if (grdValues.length == 1){
                return grdValues[0]*percent[0]/100;
            }else{
                double[] grdValuesMinusOne = new double[grdValues.length - 1];
                double[] percentMinusOne = new double[percent.length - 1];
                for (int i = 0; i < grdValuesMinusOne.length; i++){
                    grdValuesMinusOne[i] = grdValues[i];
                    percentMinusOne[i] = percent[i];
                }
                res = grdValues[grdValues.length - 1]*percent[percent.length - 1]/100;
                return res + calc.calc(false, avgValue, grdEditable, grdValuesMinusOne, percentMinusOne);
            }
        }
    }
}
