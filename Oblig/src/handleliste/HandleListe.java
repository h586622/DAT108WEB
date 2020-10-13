package handleliste;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HandleListe {
	
    private List<String> items = new ArrayList<>();
    
    public HandleListe() {
    	this.items = new ArrayList<>();
    }
    
    public void addItem(String item) {
        items.add(item);
    }
    
    public List<String> getItems() {
        return items;
    }
    
    public void slettItem(String navn) {
    	items = items.stream().filter(s -> !s.equals(navn)).collect(Collectors.toList());
    }

	public void setItems(List<String> items) {
		this.items = items;
	}
    

}
