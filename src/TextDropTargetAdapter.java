import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

class TextDropTargetAdapter extends DropTargetAdapter {
    private JTextField[][] textFields;

    public TextDropTargetAdapter(JTextField[][] textFields) {
        this.textFields = textFields;
    }

    public void drop(DropTargetDropEvent dtde) {
        try {
            Transferable tr = dtde.getTransferable();
            String s = (String) tr.getTransferData(DataFlavor.stringFlavor);
            DropTarget target = (DropTarget) dtde.getSource();
            JTextField field = (JTextField) target.getComponent();
            field.setText(s);
            dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
