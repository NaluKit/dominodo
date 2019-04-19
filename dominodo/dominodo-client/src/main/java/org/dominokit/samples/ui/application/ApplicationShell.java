package org.dominokit.samples.ui.application;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.samples.DominoDoContext;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Shell("application")
public class ApplicationShell
    extends AbstractShell<DominoDoContext> {

  public ApplicationShell() {
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We append the ShellView to the browser body.
   */
  @Override
  public void attachShell() {
    Layout layout = Layout.create("Nalu - Simple Application using Domino-UI")
                          .show(ColorScheme.INDIGO);

    layout.showFooter()
          .fixFooter()
          .getFooter()
          .setId("footer")
          .style()
          .setMinHeight("42px");

    layout.getLeftPanel()
          .setId("navigation");
    layout.getContentPanel()
          .appendChild(Row.create()
                          .appendChild(Column.span12()
                                             .setId("content")));

    MediaQuery.addOnMediumAndDownListener(layout::unfixLeftPanelPosition);
    MediaQuery.addOnLargeAndUpListener(layout::fixLeftPanelPosition);
  }

  @Override
  public void onAttachedComponent() {
    DomGlobal.window.console.log("ApplicationShell: 'onAttachedComponent' called");
  }

}
