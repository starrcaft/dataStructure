package controller;

public class CalculatorException extends Exception {
    /**
     *
     */
    public static final long serialVersionUID= 1L;
    //private Instance Var
    private CalculatorError _error;

    //getter setter
    public CalculatorError error() { return _error; }
    public void setError(CalculatorError newError) { this._error = newError; }

    //constructors
    public CalculatorException(){ this.setError(CalculatorError.Undefined); }
    public CalculatorException(CalculatorError givenError){ this.setError(givenError);}
}
