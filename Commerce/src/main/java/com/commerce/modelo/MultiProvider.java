package com.commerce.modelo;



public class MultiProvider {
			
		
      private Proveedor proveedor;
	  private BankCount[]  newBankAccount;
	  private Long[] deletedProviders;
	  private BankCount[] updateBankAccount;
	
	  
	  public MultiProvider(Proveedor provider){
		  this.proveedor = provider;
		  newBankAccount= new BankCount[20];
	   }
	   
	   public MultiProvider(){
		   
	   }

	    public Proveedor getProveedor() {
			return proveedor;
		}

		public void setProveedor(Proveedor proveedor) {
			this.proveedor = proveedor;
		}


		public Long[] getDeletedProviders() {
			return deletedProviders;
		}

		public void setDeletedProviders(Long[] deletedProviders) {
			this.deletedProviders = deletedProviders;
		}
	  
		
		public BankCount[] getNewBankAccount() {
				return newBankAccount;
		}

		public void setNewBankAccount(BankCount[] newBankAccount) {
				this.newBankAccount = newBankAccount;
		}
		
		
		 public BankCount[] getUpdateBankAccount() {
				return updateBankAccount;
			}

			public void setUpdateBankAccount(BankCount[] updateBankAccount) {
				this.updateBankAccount = updateBankAccount;
			}
	  
}
