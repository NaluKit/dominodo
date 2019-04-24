package org.dominokit.samples.event;

import org.gwtproject.event.shared.Event;

public class RefreshEvent
    extends Event<RefreshEvent.RefreshChangeHandler> {

  public static Type<RefreshEvent.RefreshChangeHandler> TYPE = new Type<RefreshEvent.RefreshChangeHandler>();

  public RefreshEvent() {
    super();
  }

  @Override
  public Type<RefreshEvent.RefreshChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(RefreshEvent.RefreshChangeHandler handler) {
    handler.onRefreshChange(this);
  }

  public interface RefreshChangeHandler {

    void onRefreshChange(RefreshEvent event);

  }

}
