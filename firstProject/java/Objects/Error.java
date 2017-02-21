package Objects;
import java.util.HashMap;



public class Error {
		
	
     private HashMap<String,String> errors;
     private boolean isLogic;
     
    
	 public Error(){
			 errors = new HashMap<String,String>();
	 }

	 
	 public Error(String keyError,String value){
		 
		 if(keyError!=null  && !keyError.isEmpty() && value!=null && !value.isEmpty())
			 errors.put(keyError,value);
	 }

	 public void addMessageError(MessageError messageError){
		 	if(messageError!=null){
		 		 errors.put(messageError.getKey(), messageError.getValue());
		 	}
	 }
	 
	 
	 public boolean existError(String keyError){
		   boolean salir=errors.containsKey(keyError);
		   return salir;
	 }
	 
	 public boolean isEmpty(){
		 return errors.isEmpty();
	 }
	 
	 public HashMap<String, String> getErrors() {
		return errors;
	 }

	 public String getError(String keyError){
		 String result="";
		 if(keyError!=null && !keyError.isEmpty())
			result=errors.get(keyError);
		 return result;
	 }
	
	 
	 
	 public boolean isLogic() {
			return isLogic;
     }

	public void setLogic(boolean isLogic) {
			this.isLogic = isLogic;
	}
	 
	public void setError(String keyError,String message){
		if(keyError!=null && message!=null && !keyError.isEmpty() && !message.isEmpty()){
			//error 
			errors.put(keyError,message);
		}
	}

}
