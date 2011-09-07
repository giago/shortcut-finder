package com.la.shortcuts.client.widgets.buttons;

import com.google.gwt.event.shared.HandlerManager;

public abstract class GridButton extends ImageButton {
	
	protected HandlerManager eventBus;
	private Long id;

	public GridButton(String label, String styleName, Long id, HandlerManager eventBus) {
		super(label, styleName);
		this.id = id;
		this.eventBus = eventBus;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
