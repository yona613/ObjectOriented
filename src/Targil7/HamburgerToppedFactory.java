package Targil7;

public class HamburgerToppedFactory {
    public static Hamburger createHamburger(String code, Hamburger hamburger){
      switch (code){
          case "ch":
              return new ChipsHamburger(hamburger);
          case "or":
              return new OnionRingsHamburger(hamburger);
          case "sa":
              return new SaladHamburger(hamburger);
          case "fe":
              return new FriedEggsHamburger(hamburger);
          default:
              throw new RuntimeException("wrong Targil7.B.Hamburger");
      }
    }
}

