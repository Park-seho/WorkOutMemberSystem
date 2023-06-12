package gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import manager.MemberManager;
import members.MemberInput;

public class MemberViewer extends JPanel{
	
	WindowFrame frame;
	
	MemberManager membermanager;

	public MemberViewer(WindowFrame frame, MemberManager membermanager) {
		this.frame = frame;
		this.membermanager = membermanager;
		
		System.out.println("***"+membermanager.size()+"***");
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Email");
		model.addColumn("Contact Info.");
		
		for(int i = 0; i < membermanager.size(); i++) {
			Vector row = new Vector();
			MemberInput mi = membermanager.get(i);
			row.add(mi.getId());
			row.add(mi.getName());
			row.add(mi.getEmail());
			row.add(mi.getPhone());
			model.addRow(row);
		}
		
		JTable table = new JTable(model); 
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
	}

}
