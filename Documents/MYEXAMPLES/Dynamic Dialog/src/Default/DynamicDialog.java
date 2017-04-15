package Default;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DynamicDialog extends Dialog {
	private Text text;
	private Text text_1;
	private Composite composite;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public DynamicDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		ScrolledComposite scrolledComposite = new ScrolledComposite(container,
				SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new FormLayout());

		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));

		final Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new GridLayout(4, false));
		final FormData fd_composite_1 = new FormData();
		fd_composite_1.top = new FormAttachment(0);
		fd_composite_1.left = new FormAttachment(0, 10);
		fd_composite_1.bottom = new FormAttachment(0, 85);
		fd_composite_1.right = new FormAttachment(0, 430);
		composite_1.setLayoutData(fd_composite_1);
		composite.setSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		Label label = new Label(composite_1, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		label.setText("1");

		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		text = new Text(composite_1, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnDelete = new Button(composite_1, SWT.NONE);
		btnDelete.setText("delete");

		final Composite composite_2 = new Composite(composite, SWT.NONE);
		composite_2.setLayout(new GridLayout(2, false));
		final FormData fd_composite_2 = new FormData();
		fd_composite_2.bottom = new FormAttachment(100, -91);
		fd_composite_2.top = new FormAttachment(0, 91);
		fd_composite_2.right = new FormAttachment(100, -10);
		fd_composite_2.left = new FormAttachment(100, -74);
		composite_2.setLayoutData(fd_composite_2);
		new Label(composite_2, SWT.NONE);

		Button btnAdd = new Button(composite_2, SWT.NONE);
		btnAdd.setText("ADD");

		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			
				Label label2 = new Label(composite_1, SWT.NONE);
				label2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
						false, 1, 1));
				label2.setText("1");

				Text text_12 = new Text(composite_1, SWT.BORDER);
				text_12.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));

				Text text13 = new Text(composite_1, SWT.BORDER);
				text13.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
						false, 1, 1));

				Button btnDelete = new Button(composite_1, SWT.NONE);
				btnDelete.setText("delete");
				composite_1.layout(true);
				 Point p0 = composite_1.getSize();
				 
				composite_1.layout();
				// Point p = composite.getSize();
				// composite.setSize(SWT.DEFAULT,SWT.DEFAULT);
				// composite.setSize(p);

				composite.layout();
				parent.layout();

			}
		});

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		 shell.setLayout(new FillLayout());

		DynamicDialog dd = new DynamicDialog(shell);
		dd.open();

	}

}
