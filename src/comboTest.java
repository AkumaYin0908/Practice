import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class comboTest extends JFrame{
	
	
	private JComboBox<String> cbxProvince;
	private JComboBox<String> cbxMunCity;
	private JComboBox<String> cbxBrgy;
	private SortedComboBoxModel<String> cbxMProv;
	private SortedComboBoxModel<String>	 cbxMMunCity;
	private SortedComboBoxModel<String> cbxMBrgy;
	private List<Province> province;
	private List<MunCity> munCity;
	private	List<Barangay> barangay;
	private JsonElement fileElement;
	private JsonObject fileObject;
	private JSONParser parser;
	private FileReader reader;
	private JSONObject obj,key;
	private JSONArray JSONPerson;
	
	private List<Person>person;
	private int provCode, munCityCode;
	private String munCityName,provName,brgyName;
	private int regCode,regDesc;
	
	public comboTest() throws IOException, ParseException {
		initialize();
	}
	private void initialize() throws IOException, ParseException  {
		setBounds(0, 0,500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		/*String source= new File("").getAbsolutePath()+"\\src\\mock.json";
		parser=new JSONParser();
		reader=new FileReader(source);
		obj=(JSONObject) parser.parse(reader);
		
		
		
		arr=(JSONArray)obj.get("person");
		Iterator<Object> iterator=arr.iterator();
		
		while(iterator.hasNext()) {
			JSONObject person=(JSONObject) iterator.next();
			cbxMID.addElement( person.get("id").toString());
		}*/
		
		
		
		
			
		cbxProvince=new JComboBox<>(getcbxMProv());
		cbxProvince.setBorder(new TitledBorder(null, "Province", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cbxProvince.setBounds(10, 56, 200, 46);
		getContentPane().add(cbxProvince);
		
		cbxMunCity = new JComboBox<>();
		cbxMunCity.setBorder(new TitledBorder(null, "Municipality", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cbxMunCity.setBounds(258, 56, 200, 46);
		getContentPane().add(cbxMunCity);
		
		cbxBrgy = new JComboBox<>();
		cbxBrgy.setBorder(new TitledBorder(null, "Barangay", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		cbxBrgy.setBounds(126, 130, 200, 46);
		getContentPane().add(cbxBrgy);
		
		cbxProvince.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					province=getProvince();
					for (Province pro:province){
						if(pro.getProvName().equals(cbxProvince.getSelectedItem())){
							System.out.println(pro.getProvCode());
							munCity=getMunCity();
							cbxMMunCity=new SortedComboBoxModel<>();
							for(MunCity mun: munCity) {
								if(mun.getProvCode()==pro.getProvCode()) {
									cbxMMunCity.addElement(mun.getMunCityName());
									
								}
							}
							
						}
					
						
					}
					
				} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cbxMunCity.setModel(cbxMMunCity);
			}
		});
		
		cbxMunCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbxMBrgy=new SortedComboBoxModel<>();
				
					
						try {
							province=getProvince();
						
							for(Province pro:province) {
								if(pro.getProvName().equals(cbxProvince.getSelectedItem())) {
									System.out.println("Regcode: "+pro.getRegCode());
						
								munCity=getMunCity();
								for(MunCity mun: munCity) {
									if (mun.getMunCityName().equals(cbxMunCity.getSelectedItem()) && mun.getProvCode()==pro.getProvCode() && mun.getRegDesc()==pro.getRegCode()){
										System.out.println(mun.getMunCityCode());
										System.out.println("RegDesc: " + mun.getRegDesc());
									
										barangay=getBarangay();
										for(Barangay brgy:barangay) {												
													if(brgy.getMunCityCode()==mun.getMunCityCode()) {
													cbxMBrgy.addElement(brgy.getBrgyName());
													}
												
												
											}
										}		
							
					
						
								}
							}
						}
						} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					cbxBrgy.setModel(cbxMBrgy);
						
				}
				
			
		});
	}
	public List<Person> getPeople() throws IOException, ParseException{
		person=new ArrayList<>();
		
		String source= new File("").getAbsolutePath()+"\\src\\mock.json";
		parser=new JSONParser();
		reader=new FileReader(source);
		obj=(JSONObject) parser.parse(reader);
		
		JSONPerson=(JSONArray) obj.get("person");
		
		for(int i=0;i<JSONPerson.size();i++) {
		key=(JSONObject)JSONPerson.get(i);
			
			String id=key.get("id").toString();
			String lastName=(String)key.get("last_name");
			String firstName=(String)key.get("first_name");
			String email=(String) key.get("email");
			String gender=(String) key.get("gender");
			String ipAddress=(String)key.get("ip_address");
			
			person.add(new Person(Integer.parseInt(id),firstName,lastName,email,gender,ipAddress));
		}
		return person;
		
	}
	
	public List<Province>getProvince() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		
		
		province=new ArrayList<>();
		String source= new File("").getAbsolutePath()+"\\src\\resources\\refprovince.json";
		fileElement=JsonParser.parseReader(new FileReader(source));
		fileObject=fileElement.getAsJsonObject();
		
		
		JsonArray proArray=fileObject.get("province").getAsJsonArray();
		for(JsonElement pro:proArray) {
			JsonObject key=pro.getAsJsonObject();
			
			provCode=key.get("provCode").getAsInt();
			provName=key.get("provDesc").getAsString();
			regCode=key.get("regCode").getAsInt();
			
			province.add(new Province(provCode,provName,regCode));
			
		}
	
		
		return province;
				
	}
	public List<MunCity>getMunCity() throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		munCity=new ArrayList<>();
		String source= new File("").getAbsolutePath()+"\\src\\resources\\refcitymun.json";
		fileElement=JsonParser.parseReader(new FileReader(source));
		fileObject=fileElement.getAsJsonObject();
		
	JsonArray munArray=fileObject.get("muncity").getAsJsonArray();
		
		for(JsonElement mun:munArray) {
			JsonObject key=mun.getAsJsonObject();
			provCode=key.get("provCode").getAsInt();
			munCityName=key.get("citymunDesc").getAsString();
			munCityCode=key.get("citymunCode").getAsInt();
			regDesc=key.get("regDesc").getAsInt();
			
			munCity.add(new MunCity(munCityCode,munCityName,provCode,regDesc));
		}
		return munCity;
	}
	
	public List<Barangay> getBarangay() throws JsonIOException, JsonSyntaxException, FileNotFoundException{
		
		barangay=new ArrayList<>();
		String source= new File("").getAbsolutePath()+"\\src\\resources\\refbrgy.json";
		fileElement=JsonParser.parseReader(new FileReader(source));
		fileObject=fileElement.getAsJsonObject();
		
		
		JsonArray brgyArray=fileObject.get("barangay").getAsJsonArray();
		for(JsonElement brgy:brgyArray) {
			JsonObject key=brgy.getAsJsonObject();
			munCityCode=key.get("citymunCode").getAsInt();
			brgyName=key.get("brgyDesc").getAsString();
			provCode=key.get("provCode").getAsInt();
			regCode=key.get("regCode").getAsInt();
			barangay.add(new Barangay(munCityCode,brgyName,provCode,regCode));
			
		}
		return barangay;
	}
	public void JsonGetSource() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		String source= new File("").getAbsolutePath()+"\\src\\resources\\refprovince.json";
		fileElement=JsonParser.parseReader(new FileReader(source));
		fileObject=fileElement.getAsJsonObject();
		
	}
	
	public SortedComboBoxModel<String> getcbxMProv() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		cbxMProv=new SortedComboBoxModel<>();
		province=getProvince();
		Iterator<Province> proIterator=province.iterator();
			while(proIterator.hasNext()) {
				Province pro=proIterator.next();
				cbxMProv.addElement(pro.getProvName());
				
			}
		return cbxMProv;
		
	}
	
	
	
}
 class SortedComboBoxModel<E extends Comparable<? super E>> extends DefaultComboBoxModel<E> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SortedComboBoxModel() {
        super();
    }

    public SortedComboBoxModel(E[] items) {
        Arrays.sort(items);
        int size = items.length;
        for (int i = 0; i < size; i++) {
            super.addElement(items[i]);
        }
        setSelectedItem(items[0]);
    }

    public SortedComboBoxModel(Vector<E> items) {
        Collections.sort(items);
        int size = items.size();
        for (int i = 0; i < size; i++) {
            super.addElement(items.elementAt(i));
        }
        setSelectedItem(items.elementAt(0));
    }

    @Override
    public void addElement(E element) {
        insertElementAt(element, 0);
    }

    @Override
    public void insertElementAt(E element, int index) {
        int size = getSize();
        for (index = 0; index < size; index++) {
            Comparable<E> c = (Comparable) getElementAt(index);
            if (c.compareTo(element) > 0) {
                break;
            }
        }
        super.insertElementAt(element, index);
    }
    
    
}
