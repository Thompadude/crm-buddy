package managers;

import java.util.ArrayList;
import java.util.Scanner;

public class NullManage {

	public <T>boolean nullCheckArrayList(ArrayList<T> t) {
		if (t == null) {
			return true;
		}
		return false;
	}
}
