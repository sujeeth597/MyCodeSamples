import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Drawable;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.GCData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

public class ExampleClass {
  
public static void main (String [] args) {
  final Display display = new Display ();
  final Image image = new Image (display, 16, 16);
  image.setBackground(display.getSystemColor (SWT.COLOR_RED));
  final GC gc = new GC (display);
  gc.drawImage(image, display.getClientArea().x, display.getClientArea().y);
  gc.setBackground (display.getSystemColor (SWT.COLOR_RED));
  gc.fillRectangle (image.getBounds());
  gc.dispose ();
  final Shell shell = new Shell (display);
  shell.setText ("Lazy Table");
  shell.setLayout (new FillLayout ());
  final Table table = new Table (shell, SWT.BORDER | SWT.MULTI);
  table.setSize (200, 200);
  Thread thread = new Thread () {
    public void run () {
      for (int i=0; i<20000; i++) {
        if (table.isDisposed ()) return;
        final int [] index = new int [] {i};
        display.syncExec (new Runnable () {
          public void run () {
            if (table.isDisposed ()) return;
            TableItem item = new TableItem (table, SWT.NONE);
            final Image image = new Image (item.getDisplay(), 16, 16);
            final GC gc = new GC (item.getDisplay());
            gc.drawImage(image, item.getBounds().x, item.getBounds().y);
            gc.setBackground (item.getDisplay().getSystemColor (SWT.COLOR_RED));
            gc.fillRectangle (image.getBounds());
            gc.dispose ();
            item.setText ("Table Item " + index [0]);
            item.setImage (image);
          }
        });
      }
    }
  };
  thread.start ();
  shell.setSize (200, 200);
  shell.open ();
  while (!shell.isDisposed ()) {
    if (!display.readAndDispatch ()) display.sleep ();
  }
  image.dispose ();
  display.dispose ();
}
}