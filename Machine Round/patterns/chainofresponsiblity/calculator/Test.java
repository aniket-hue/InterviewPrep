package patterns.chainofresponsiblity.calculator;

/**
 * A Design pattern that forms a sequentially connected components and helps consumer to simply pass the request to the next component in the chain.
 * then the next component in the chain will handle the request.
 *
 * This pattern guarantees running procedures in a sequential order i.e. synchronous order.
 *
 * https://bumbu.me/javascript-chain-of-responsibility-pattern-with-promises/
 * https://www.youtube.com/watch?v=P9DHX5aBL6I
 * https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
 * https://stackoverflow.com/questions/15446351/is-javas-exception-handling-mechanism-an-example-of-the-chain-of-responsibility
 * https://medium.com/geekculture/loose-coupling-with-chain-of-responsibility-bf0937028276
 * https://jsmanifest.com/power_of_chain_of_responsibility_in_javascript/
 */

public class Test {
    public static void main(String[] args) {
        Chain chain1 = new AddNumbers();
        Chain chain2 = new SubtractNumbers();
        Chain chain3 = new MultiplyNumbers();
        Chain chain4 = new DivideNumbers();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);

        Numbers  request = new Numbers(4, 2, "add");
        chain1.calculate(request);
    }
}
