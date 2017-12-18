package Model;

public class FxModel {

	long _value;

    public FxModel(){
        reset();
    }

    public void reset(){
        this._value = 0;
    }

    public void calculate(long wert){
        this._value =  (wert * wert);
    }

    public long getValue(){
        return this._value;
    }
	
	
}
