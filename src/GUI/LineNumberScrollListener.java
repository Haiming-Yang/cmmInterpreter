package GUI;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JScrollPane;
public class LineNumberScrollListener implements AdjustmentListener{
	private JScrollPane scroll = null;
	public LineNumberScrollListener(JScrollPane scroll) {
		super();
		this.scroll = scroll;
	}
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		scroll.getVerticalScrollBar().setValue(e.getValue());
	}

}
