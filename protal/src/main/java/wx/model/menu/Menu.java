package wx.model.menu;

import java.util.List;

public class Menu extends Button {
	private List<Button> button;

	public List<Button> getButton() {
		return this.button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}
}
