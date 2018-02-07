import java.util.Scanner;
 
class ques{
 public static void main(String[] args){
Scanner sc=new Scanner(System.in);
int tc=sc.nextInt();
 
int n=0,nop=0;
int a[][];
int b[][];
boolean pos=false;
 
int num=0,fp=0;
 
//test cases begins
for(int i=0; i<tc; i++){
	num=0;
	
	n=sc.nextInt();
	nop=(int)Math.floor(n/10.0);
	fp=0;
	
	pos=false;
	
	a=new int[n][2];
	b=new int[nop][2];
	for(int j=0; j<n; j++){
		a[j][0]=sc.nextInt();
		a[j][1]=sc.nextInt();
		if(a[j][0]<=a[fp][0]){
			fp=j;
		}
	}
	
 //test
 //System.out.println("hi nop"+nop);
 //System.out.println("fp="+a[fp][0]+", "+a[fp][1]);
 
 
	int lp,rp,xmin,xc,yl,yr;
	//solve from here
	if(fp==0){lp=n-1; rp=1;}
	else if(fp==n-1){lp=n-2; rp=0;}
	else{ lp=fp-1; rp=fp+1;}
	
	xc=a[fp][0];
	
	while((num<nop)&&(lp!=rp)){
xmin=Math.min(a[lp][0],a[rp][0]);
				
	for(int j=xc+1; j<=xmin; j++){
		
	yl=(int)Math.floor(a[fp][1]+(j-a[fp][0])*((a[lp][1]-a[fp][1])/(double)(a[lp][0]-a[fp][0])));	
		
	yr=(int)Math.ceil(a[fp][1]+(j-a[fp][0])*((a[rp][1]-a[fp][1])/(double)(a[rp][0]-a[fp][0])));
	
 //test
 //System.out.println("test"+yr+" "+yl);
 //System.out.println("j="+j);
	for(int k=yr+1;!pos && k<yl; k++){
		b[num][0]=j;
		b[num][1]=k;
  num++;
 
//System.out.println("numy "+num);
//System.out.println("q="+b[num-1][0]+" "+b[num-1][1]); 
  
 //System.out.println("posq="+pos);
  if(num==nop){pos=true; break;}
// System.out.println("pos="+pos);   
	}				
 }	
 //System.out.println("pos="+pos);
 
	xc=xmin;
	
	if(a[lp][0]==xmin){
		if(lp==0){lp=n-1;}
		else{lp--;}
	}
	else{
		if(rp==n-1){rp=0;}
		else{rp++;}
	}
	
	
//	System.out.println("num"+num);
	
				
		if(num==nop){pos=true;}		
	}//finding points end
	
		
	if(pos){
		for(int j=0; j<nop; j++){
		System.out.print(b[j][0]+" "+b[j][1]+"\n");
		}		
	}else{
		System.out.println("-1\n");
	}
		
}//end of tc
 
 	 
 sc.close();   
  }
}
 
