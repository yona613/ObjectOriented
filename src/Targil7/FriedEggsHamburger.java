package Targil7;

public class FriedEggsHamburger implements Hamburger{

    private final Hamburger myHamburger;

    public FriedEggsHamburger(Hamburger hamburger){
        myHamburger = hamburger;
    }

    @Override
    public String serve() {
        return myHamburger.serve() + " with fried egg";
    }
}
