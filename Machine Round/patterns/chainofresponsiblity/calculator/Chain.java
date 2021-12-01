package patterns.chainofresponsiblity.calculator;

interface Chain {
    public void setNextChain(Chain nextChain);

    public void calculate(Numbers request);
}

