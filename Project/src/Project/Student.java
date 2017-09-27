package Project;

public class Student {

	int verified =0;
	
	public void newEntry(Controller c) {
		//getText and send to sql
		
		//if successful then change verified to 1
		verified=1;
	}

	public void vRecords(Controller c) {
		//getText and check with sql records

		//if successful then change verified to 1
		verified=2;
	}
	
	public void toMySQL(Controller c) {
		
		// send student data to sql
		
		
	}
	
	public void upload(Controller c) {
		
		//using filechooser get image and show in labels
		// send to sql table.
	}
}
