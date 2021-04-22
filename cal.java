import java.util.*;
import java.text.*;

class cal
{
 static final String monthNames[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

 public static void main(String...arg)
 {
  Date dt=new Date();
  int d,m,y;

  m=dt.getMonth()+1;
  y=dt.getYear()+1900;

  if(arg.length>2)
  {
   System.err.println("\ntoo many parameters..\n");
   System.exit(1);
  }
  else  
  if(arg.length==1)
  {
   int i;
   for(i=0;i<12 && !monthNames[i].equalsIgnoreCase(arg[0]);i++);
   if(i==12)
   {
    System.err.println("\ninvalid month name - "+arg[0]+"\n");
    System.exit(2);
   }
   m=i+1;   
  }  
  else
  if(arg.length==2)
  {
   int i;
   for(i=0;i<12 && !monthNames[i].equalsIgnoreCase(arg[0]);i++);
   if(i==12)
   {
    System.err.println("\ninvalid month name - "+arg[0]+"\n");
    System.exit(2);
   }
   m=i+1;
   
   try
   {
    y=Integer.parseInt(arg[1]);
    if(y<1900||y>9999)
     throw new NumberFormatException("year must be in the range 1900-9999");
   }
   catch(NumberFormatException e)
   {
    System.err.println("\ninvalid year - "+e.getMessage()+"\n");
    System.exit(2);
   }   
  }  
     
  dt=new Date(y-1900,m-1,1);
  int totdays=28;
  if(m==1 || m==3 || m==5 || m==7 || m==8 || m==10 || m==12)
   totdays+=3;
  else
  if(m==4 || m==6 || m==9 || m==11)
   totdays+=2;
  else
  {
   if(y%4==0 && y%100!=0 || y%400==0)
    totdays+=1;
  }

  int w=dt.getDay();
  String s=new SimpleDateFormat("MMMM y").format(dt);

  StringBuffer sb=new StringBuffer();
  sb.setLength((26-s.length())/2);
  sb.append(s);
    
  System.out.println("\n"+sb);
  System.out.println("\nSu  Mo  Tu  We  Th  Fr  Sa");
    
  sb.setLength(0);
  sb.setLength(w*4);
  System.out.print(sb);

  for(d=1;d<=totdays;d++,w++)
  {
   System.out.printf("%2d  ",d);
   if(w==6)
   {
    System.out.println();
    w=-1;
   }
  }
  System.out.println("\n");
 }
}