package Targil7;

public class ChipsHamburger implements Hamburger{

    private final Hamburger myHamburger;

    public ChipsHamburger(Hamburger hamburger){
        myHamburger = hamburger;
    }

    @Override
    public String serve() {
        return myHamburger.serve() + " with chips";
    }
}
