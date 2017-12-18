package Controller;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import View.FxView;
import Model.FxModel;


public class FxController {
	
	private FxView _view;
    private FxModel _model;
    
    public FxController(){
        this._model = new FxModel();
        this._view = new FxView();

        this.addListener();
    }
    
    
    public void showView(){
        _view.startView();
    }
    
    
    
    
    private void addListener(){
        this._view.setSnarexBerechnenListener(new SnarexCalcListener());
        this._view.setResetFormListener(new ResetFormListener());
    }
    
    class SnarexCalcListener implements EventHandler <ActionEvent>{
    	public void handle(ActionEvent click) {
            long wert = Long.valueOf(_view.getEingabe());
            _model.calculate(wert);
            _view.setErgebnis(String.valueOf(_model.getValue()));
        }
    }

    class ResetFormListener implements EventHandler <ActionEvent>{
           
		public void handle(ActionEvent click) {
			 _view.resetView();
	            _model.reset();
			
		}
    }
    
}
