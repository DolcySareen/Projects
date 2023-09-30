import javafx.application.Application ;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MineSweeper2 extends Application{
	
	int position;
	static int count=0;
	int number=0;
	 static int flags=10;
	
	static  int [][] value= new int[8][8];
	
	public static void assigning() {
	    int [][] value1= new int[8][8];
		int row;
		int col;
	   for(int i=0;i<10;i++)
	     {
		    row=(int)(Math.random()*8);
		    col=(int) (Math.random()*8);
		    
	       if(value[col][row]!=4)
	       {
	    	    value1[col][row]=4; 
	       } else if(value[col][row]==4) {
	       
	    	     row=(int)(Math.random()*8);
			     col=(int) (Math.random()*8);
			     if(value[col][row]!=4) {
			     value1[col][row]=4;
			     }else
			     {
			    	 row=(int)(Math.random()*8);
				     col=(int) (Math.random()*8);
				     value1[col][row]=4;
			     }
	       }
	           value[col][row]=value1[col][row];
	       
	     }
	
	    
	     	
	     for(int j=0;j<8;j++)
	     {
	    	 for(int i=0;i<8;i++)
	    	 {
	    		 int noOfMines=0;
	    		 
	    		    if(j==0 && i==0 && i<1 && j<1)
	    		    {
	    		    	if(value1[j][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    }else if(j==0 && j<1 && i>=1 && i<7)
	    		    {
	    		    	if(value1[j][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j][i-1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i-1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		   
    
	    		  }else if(j==7 && i==7 && j>=1 && i>=1)
	    			 {
	    				 if(value1[j][i-1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i-1]==4) 
		    		    	{
		    		    		noOfMines++;
		    		    	}
	    			 }else if(j==7 && i>=1 && i<7 && j>=1)
	    			 {
	    				 if(value1[j][i-1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j][i+1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i-1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i+1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
    			      }else if(i==0 && j>=1 && j<7)
    			      {
    			    	  if(value1[j][i+1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i+1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j+1][i]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j+1][i+1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
    			      }else if(i==7 && i>=1 && j>=1 && j<7)
    			      {
    			    	  if(value1[j-1][i]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j+1][i]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j-1][i-1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j+1][i-1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
		    		    	if(value1[j][i-1]==4)
		    		    	{
		    		    		noOfMines++;
		    		    	}
    			      }else if( j==7 && i==0)
    			      {
    			    	  if(value1[j-1][i]==4)
  	    		    	{
  	    		    		noOfMines++;
  	    		    	}
  	    		    	if(value1[j][i+1]==4)
  	    		    	{
  	    		    		noOfMines++;
  	    		    	}
  	    		    	if(value1[j-1][i+1]==4)
  	    		    	{
  	    		    		noOfMines++;
  	    		    	}
    			      }else if(j==0 && i==7)
    			      {
    			    	  if(value1[j][i-1]==4)
  	    		    	{
  	    		    		noOfMines++;
  	    		    	}
  	    		    	if(value1[j+1][i]==4)
  	    		    	{
  	    		    		noOfMines++;
  	    		    	}
  	    		    	if(value1[j+1][i-1]==4)
  	    		    	{
  	    		    		noOfMines++;
  	    		    	}
    			      
	    		     }
	    		    if(j>=1 && j<7 && i>=1 && i<7)
	    		     {
	    		    	if(value1[j-1][i-1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j-1][i]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j-1][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j][i-1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i-1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}if(value1[j+1][i]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	}
	    		    	if(value1[j+1][i+1]==4)
	    		    	{
	    		    		noOfMines++;
	    		    	} 		    	 
	    		 }   
	    	 
	     
	    		 if(noOfMines==0 && value[j][i]!=4)
	    		 {
	    			 value1[j][i]=0;
	    		 }else if(noOfMines==1 &&  value[j][i]!=4)
	    		 {
	    			 value1[j][i]=1;
	    		 }else if(noOfMines==2 && value[j][i]!=4)
	    		 {
	    			 value1[j][i]=2;
	    		 }else if(noOfMines==3 && value[j][i]!=4)
	    		 {
	    			 value1[j][i]=3;
	    		 }
	    	     
	    		 value[j][i]=value1[j][i];
	     
	       }
	    		    
	       }
	     } 	 
	    	 
	     
   
	 
     
	 
	     
	
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
          launch(args);
          
	}
	public void start(Stage theStage)
	{
		assigning();
		VBox rootPane = new VBox();
		HBox pane1 =new HBox(50);
		HBox hbx= new HBox();
		pane1.setAlignment(Pos.CENTER);
		//Button btn1=new Button();
    	HBox timer=new HBox();
    	Image image=new Image("file:res/face-smile.png");
    	Image image1=new Image("file:res/face-dead.png");
    	Image image2=new Image("file:res/face-win.png");
    	
    	Image  digit1=new Image("file:res/1D.png");
    	
    	Image digit2=new Image("file:res/2D.png");
    	Image digit3=new Image("file:res/3D.png");
    	Image  digit4=new Image("file:res/4D.png");
    	Image digit5=new Image("file:res/5D.png");
    	Image digit6=new Image("file:res/6D.png");
    	Image  digit7=new Image("file:res/7D.png");
    	Image digit8=new Image("file:res/8D.png");
    	Image digit9=new Image("file:res/9D.png");
    	Image digit0=new Image("file:res/0D.png");
  	    Image digit02=new Image("file:res/0D.png");
        Image digit03=new Image("file:res/0D.png");
        Image digit04=new Image("file:res/0D.png");
        Image time1=new Image("file:res/0D.png");
  	    Image time2=new Image("file:res/0D.png");
        Image time3=new Image("file:res/0D.png");
    	ImageView D1=new ImageView(digit1);
        ImageView D2=new ImageView(digit2);
         ImageView D3=new ImageView(digit3);
        ImageView D4=new ImageView(digit4);
        ImageView D5=new ImageView(digit5);
        ImageView D6=new ImageView(digit6);
        ImageView D7=new ImageView(digit7);
        ImageView D8=new ImageView(digit8);
        ImageView D9=new ImageView(digit9);
        ImageView D01=new ImageView(digit0);
        ImageView D02=new ImageView(digit02);
         ImageView D03=new ImageView(digit03);
         ImageView D04=new ImageView(digit04);
         ImageView T01=new ImageView(digit0);
         ImageView T02=new ImageView(digit02);
          ImageView T03=new ImageView(digit03);
        ImageView iv=new ImageView(image);
        ImageView iv1=new ImageView(image1);
        ImageView iv2=new ImageView(image2);
				 
        Button button=new Button();
        button.setGraphic(iv);
        button.setOnAction(e -> {
        	count=0;
        	start(theStage);
        });
        //btn1.setGraphic(hbx);
        
        buttonForMines2 mine=new buttonForMines2 ();
    	GridPane pane2=new GridPane();
    	buttonForMines2 buttons[][]=new buttonForMines2[8][8];
    	for(int i=0;i<8;i++)
	  	  {
	  		  for(int j=0;j<8;j++)
	  		  {
	  			  buttons[i][j]= new buttonForMines2();
	  			  buttonForMines2 b=buttons[i][j];
	  					if(value[i][j]==0)
	  					{
	  						b.state=0;
	  						
	  					}else if(value[i][j]==1)
	  					{
	  						b.state=1;
	  						
	  					}else if(value[i][j]==2)
	  					{
	  						b.state=2;
	  					}else if(value[i][j]==3)
	  					{
	  						b.state=3;
	  						
	  					}else
	  					{
	  						b.state=4;
	  					}
    	
  			  b.setOnMouseClicked(e ->
  			  {
  				
  				 
  				 if((e.getButton()==MouseButton.PRIMARY && b.getGraphic()!=b.imageFlag && button.getGraphic()!=iv1)) {
  				switch(b.state)
				  {
				      case 0:
				      if(count<1) {
					  b.setGraphic(b.image0);
				      }
				      
					  number++;
					  break;
					  
				      case 1:
				    	  if(count<1) {
							  b.setGraphic(b.image1);
						      }else
						      {
						       b.setGraphic(b.cover); 
						      }
				    	  number++;
				      break;
				      
				      case 2:
				    	  if(count<1) {
							  b.setGraphic(b.image2);
						      }else
						      {
						       b.setGraphic(b.cover); 
						      }
				    	  number++;
				      break;
				      
				      case 3:
				    	  if(count<1) {
							  b.setGraphic(b.image3);
						      }else
						      {
						       b.setGraphic(b.cover); 
						      }
				    	  number++;
				      break;
				      case 4:
				    	  if(count<1) {
							  b.setGraphic(b.imagemine);
							  // arsh helped for opening mines condition
							  for(int g =0; g<8; g++) {
								  for(int s=0; s<8;s++) {
									  if(value[g][s] == 4) {
										  if(buttons[g][s].getGraphic()!=b.imagemine) {
											  buttons[g][s].setGraphic(buttons[g][s].imageBomb);
											 
										  }
									  }
								  }
							  }
							  // till here
							  
						      }
				    	     
				    	  count++;
				      break;
				    }
    			  }else if(e.getButton()==MouseButton.SECONDARY && b.getGraphic()==b.imageFlag && button.getGraphic()!=iv1)
 				  {
 					  b.setGraphic(b.cover);
 					  flags++;
 					  
 				    		
 				 }else if(e.getButton()==MouseButton.SECONDARY && button.getGraphic()!=iv1)
 				  {
 					  b.setGraphic(b.imageFlag);
 					  flags--;
 					  
 				    		
 				 }
  				 if(flags==10)
  				 {
  					 hbx.getChildren().set(1, D1);
  					 hbx.getChildren().set(2, D04);
  				 }else if(flags==9 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D9);
  					 
  				 }else  if(flags==8 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D8);
  					 
  				 }else  if(flags==7 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D7);
  					 
  				 }else  if(flags==6 &&( b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D6);
  					 
  				 }else  if(flags==5 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D5);
  					 
  				 }else  if(flags==4 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D4);
  					 
  				 }else  if(flags==3 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D3);
  					 
  				 }else  if(flags==2 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D2);
  					 
  				 }else  if(flags==1 && (b.getGraphic()==b.imageFlag ||  b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D1);
  					 
  				 }else  if(flags==0 && (b.getGraphic()==b.imageFlag || b.getGraphic()==b.cover))
  				 {
  					 hbx.getChildren().set(1, D02);
  					 hbx.getChildren().set(2, D04);
  					 
  				 }else if(flags<=0)
  				 {
  					b.setGraphic(b.cover);
  				 }
  				
  				
  				if(count >0)
		    	{
		    		button.setGraphic(iv1);
		    		
 						 
 					 }
		    	
		    	if(number==54 && count==0)
		    	{
		    		button.setGraphic(iv2);
		    	}
		    	
	  			
		    	
		  });
  			pane2.add(buttons[i][j],i,j);
  			  
	  		  }
	  		  
  	  }
    	hbx.setAlignment(Pos.CENTER);
    	 hbx.getChildren().addAll(D01,D1,D03);
       pane1.getChildren().add(hbx); 
 	   pane1.getChildren().add(button);
 	  timer.setAlignment(Pos.CENTER);
 	  timer.getChildren().addAll(T01, T02, T03);
 	   pane1.getChildren().add(timer);
 	   rootPane.getChildren().addAll(pane1,pane2);	
     	Scene scene=new Scene(rootPane,320,373);
    	theStage.setScene(scene);
    	theStage.show();
			
			
	}
    
} 
class buttonForMines2 extends Button
{
	 int state;
	ImageView cover,image0,image1,image2,image3,imageBomb,imageFlag,imagemine;
	
	 
	public buttonForMines2()
	{
		
		double size=40;
		int[][] arr=new int[8][8];
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				arr[i][j]=MineSweeper2.value[i][j];
			}
		}
		setMinWidth(size);
		setMaxWidth(size);
		setMinHeight(size);
		setMaxHeight(size);
		
		imageBomb=new ImageView(new Image("file:res/bombrevealed-bicubic.png"));
		imagemine=new ImageView(new Image("file:res/mine-red.png"));
		image0=new ImageView(new Image("file:res/0.png"));
		image1=new ImageView(new Image("file:res/1.png"));
		image2=new ImageView(new Image("file:res/2.png"));
		image3=new ImageView(new Image("file:res/3.png"));
		cover=new ImageView(new Image("file:res/cover.png"));
		imageFlag=new ImageView(new Image("file:res/flag.png"));
		cover.setFitWidth(size);
		cover.setFitHeight(size);
		image0.setFitHeight(size);
		image0.setFitWidth(size);
		image1.setFitHeight(size);
		image1.setFitWidth(size);
		image2.setFitHeight(size);
		image2.setFitWidth(size);
		image3.setFitHeight(size);
		image3.setFitWidth(size);
		cover.setFitHeight(size);
		cover.setFitWidth(size);
		imageBomb.setFitHeight(size);
		imageBomb.setFitWidth(size);
		imageFlag.setFitHeight(size);
		imageFlag.setFitWidth(size);
		imagemine.setFitHeight(size);
		imagemine.setFitWidth(size);
		
		setGraphic(cover);
		
		
	}
}

