class Lab13{
	public static void main(String args[]){
		boolean flag=true;
		if(args.length==2){
			
			for(int i=0; i<args[1].length() ; i++){
				if(!Character.isDigit(args[1].charAt(i))){
					if(Integer.parseInt(args[1]) > 0){
					flag=false;
					break;
					}else{
						System.out.println("enter positive number");
					}
				}
			}
				if(!flag){
					System.out.println("please enter a valid number for the second argument.");
					return;
				}
			for (int i=0 ; i<Integer.parseInt(args[1]);i++){
				System.out.println(args[0]);
			}
		}else{
			System.out.println("please provide 2 arg first string second number");
		}
	}
}
