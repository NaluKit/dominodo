package org.dominokit.samples;

    import com.google.gwt.core.client.EntryPoint;
    import org.gwtproject.safehtml.shared.annotations.GwtIncompatible;

public class App implements EntryPoint {

  public void onModuleLoad() {
    DominoDo application = new DominoDo();
    application.run();
  }


  @GwtIncompatible()
  public void emptyPuppa() {
    System.out.println("PIPPO IS SUPER STRONG");
  }
}
