import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TestSize {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Area");
        Container cp = frame.getContentPane();
        cp.setLayout(new FlowLayout());
        JButton btnHello = new JButton("Hello");
        btnHello.setPreferredSize(new Dimension(100, 80));
        cp.add(btnHello);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150); // or pack() the components
        frame.setLocationRelativeTo(null); // center the application window
        frame.setVisible(true); // show it

        System.out.println(btnHello.getSize());
        System.out.println(btnHello.getLocation());
        System.out.println(btnHello.getLocationOnScreen());

        System.out.println(cp.getSize());
        System.out.println(cp.getLocation());
        System.out.println(cp.getLocationOnScreen());

        System.out.println(frame.getSize());
        System.out.println(frame.getLocation());
        System.out.println(frame.getLocationOnScreen());
    }
}







/** Add or remove components from a container */

@SuppressWarnings("serial")

public class AddRemoveComponentsTest extends JFrame {

    private int numButtons = 2; // number of buttons, init to 2 (1 add, 1 remove)

    Container cp;     // content-pane of JFrame

    JButton[] buttons;   // array of buttons

    ButtonsListener listener;   // an ActionListener instance for all buttons

    /** Constructor to setup the UI components */

    public AddRemoveComponentsTest() {

        cp = getContentPane();

        // Create an instance of ActionListener to listen to all Buttons

        listener = new ButtonsListener();

        // Call helper method to create numButtons buttons

        createButtons();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Add/Remove Components Test");

        setSize(400, 150);

        setLocationRelativeTo(null);

        setVisible(true);

    }

    /** Create numButtons buttons on content-pane with FlowLayout */

    private void createButtons() {

        // For demonstration, all the components are removed, instead of

        //  add or remove selected component.

        cp.removeAll();

        cp.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        // Create buttons

        buttons = new JButton[numButtons];  // allocate array

        int i = 0;

        // Create (numButtons-1) "Add" buttons, but minimum one

        do {

            buttons[i] = new JButton("Add");

            cp.add(buttons[i]);

            buttons[i].addActionListener(listener);

            ++i;

        } while (i < numButtons - 1);

        // Create a "Remove" button if numButtons > 1

        if (i == numButtons - 1) {

            buttons[i] = new JButton("Remove");

            cp.add(buttons[i]);

            buttons[i].addActionListener(listener);

        }

        cp.validate(); // needed after adding/removing component

        repaint();     // needed to cleanup dirty background

    }

    /** Inner class used as the ActionListener for the Buttons */

    private class ButtonsListener implements ActionListener {

        @Override

        public void actionPerformed(ActionEvent e) {

            // adjust the number of buttons

            if (e.getActionCommand().equals("Add")) {

                ++numButtons;

            } else {

                if (numButtons >= 2) {

                    --numButtons;

                }

            }

            // Call helper method to create numButtons buttons

            createButtons();

        }

    }

    /** The entry main() method */

    public static void main(String[] args) {

        // Run GUI codes in the Event-Dispatching thread for thread safety

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new AddRemoveComponentsTest();  // Let the constructor do the job

            }

        });

    }

}

public class Address

{

    public String AddressLine1[get, set];

    public String City[get, set];

    public Stringtring PostCode[get, set];

}

public class ListAddressViewModel

{

    public IList<Address> AddressList { get; set; }

    public Address SelectedAddress { get; set; }

    public ListAddressViewModel()

    {

        AddressList = new List<Address>();

        init();

    }

    private void init()

    {

        AddressList = new List<Address>

        {

            new Address { AddressLine1 = "Address 1", City = "City 1", PostCode = "PostCode 1" },

            new Address { AddressLine1 = "Address 2", City = "City 2", PostCode = "PostCode 2" },

            new Address { AddressLine1 = "Address 3", City = "City 3", PostCode = "PostCode 3" },

            new Address { AddressLine1 = "Address 4", City = "City 4", PostCode = "PostCode 4" },

            new Address { AddressLine1 = "Address 5", City = "City 5", PostCode = "PostCode 5" },


        };

    }

}

public partial class Form3 : Form

        {

private System.Windows.Forms.BindingSource bindingSource1;

private ListAddressViewModel VM { get; set; }

private DataGridView dataGridView1;

public Form3()

        {

        InitializeComponent();

        this.dataGridView1 = new DataGridView();

        this.VM = new ListAddressViewModel();

        this.bindingSource1 = new System.Windows.Forms.BindingSource(this.components);

        //this.bindingSource1.DataSource = typeof(ListAddressViewModel);

        this.bindingSource1.DataSource = this.VM;

        this.dataGridView1.AllowUserToAddRows = false;

        this.dataGridView1.AllowUserToDeleteRows = false;

        this.dataGridView1.AllowUserToOrderColumns = true;

        this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;

        //this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {

        //   this.AddressLine1,

        //   this.City,

        //   this.PostCode});

        this.dataGridView1.DataBindings.Add(new System.Windows.Forms.Binding("DataSource", this.bindingSource1, "AddressList", true, System.Windows.Forms.DataSourceUpdateMode.OnPropertyChanged));

        //this.dataGridView1.Dock = System.Windows.Forms.DockStyle.Fill;

        //this.dataGridView1.Location = new System.Drawing.Point(0, 50);

        this.dataGridView1.Location = new System.Drawing.Point(33, 27);

        this.dataGridView1.MultiSelect = false;

        this.dataGridView1.Name = "dataGridView1";

        this.dataGridView1.ReadOnly = true;

        this.dataGridView1.RowHeadersVisible = false;

        this.dataGridView1.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;

        this.dataGridView1.ShowCellErrors = false;

        this.dataGridView1.ShowCellToolTips = false;

        this.dataGridView1.ShowEditingIcon = false;

        this.dataGridView1.ShowRowErrors = false;

        //this.dataGridView1.Size = new System.Drawing.Size(1014, 421);

        this.dataGridView1.Size = new System.Drawing.Size(345, 150);

        this.dataGridView1.TabIndex = 2;

        this.dataGridView1.SelectionChanged += new System.EventHandler(this.dataGridView1_SelectionChanged);

        this.Controls.Add(this.dataGridView1);

        }

//Selection Change Handler

private void dataGridView1_SelectionChanged(object sender, EventArgs e)

        {

        if (dataGridView1.SelectedRows.Count > 0)

        {

        var addr = (Address)dataGridView1.SelectedRows[0].DataBoundItem;

        var msg = String.Format("{0}, {1}, {2}", addr.AddressLine1, addr.City, addr.PostCode);

        MessageBox.Show(msg, "Message", MessageBoxButtons.OK);

        //   _vm.SelectedAddress = (Address)dataGridView1.SelectedRows[0].DataBoundItem;

        }

        }

        }

