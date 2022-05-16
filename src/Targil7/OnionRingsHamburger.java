package Targil7;

public class OnionRingsHamburger implements Hamburger{

    private final Hamburger myHamburger;

    public OnionRingsHamburger(Hamburger hamburger){
        myHamburger = hamburger;
    }

    @Override
    public String serve() {
        return myHamburger.serve() + " with onion rings";
    }
}
