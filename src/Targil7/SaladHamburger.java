package Targil7;

public class SaladHamburger implements Hamburger{

    private final Hamburger myHamburger;

    public SaladHamburger(Hamburger hamburger){
        myHamburger = hamburger;
    }

    @Override
    public String serve() {
        return myHamburger.serve() + " with salad";
    }
}
