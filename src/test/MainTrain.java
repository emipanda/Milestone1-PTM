package test;

public class MainTrain {
	
	public static boolean wrong(float val, float expected){
		return val<expected-0.001 || val>expected+0.001;
	}
	public static void printAll(float[] x , float[] y , float[] e , Line line , Point p){
		System.out.println("Array X:");
		for (int i = 0; i < x.length; i++) {
			System.out.printf( x[i] + ", ");
		}
		System.out.println();
		System.out.println("Array Y:");
		for (int i = 0; i < y.length; i++) {
			System.out.printf( y[i] + ", ");
		}
		System.out.println();
		System.out.println("The mean of X is: " + StatLib.avg(x));
		System.out.println("The mean of Y is: " + StatLib.avg(y));
		System.out.println("The variance of X is: " + StatLib.var(x));
		System.out.println("The covariance of X,Y is: " + StatLib.cov(x,y));
		System.out.println("The Pearson Correlation of X,Y is: " + StatLib.pearson(x,y));
		System.out.println("The line 'a' parameter is: " + line.a);
		System.out.println("The line 'b' parameter is: " + line.b);
		System.out.println("The line equation cals is: " + line.f(4));
		System.out.println("The deviation between point and line is: " + StatLib.dev(p,line));
		System.out.println("****************");
		System.out.println("The expected variance is: " + e[0]);
		System.out.println("The expected covariance is: " + e[1]);
		System.out.println("The expected Pearson Correlation is: " + e[2]);
		System.out.println("The expected line 'a' parameter is: " + e[3]);
		System.out.println("The expected line 'b' parameter is: " + e[4]);
		System.out.println("The expected line equation calc is: " + e[5]);
		System.out.println("The expected deviation between point and line is: " + e[6]);
	}
	public static void main(String[] args) {
		final int N=10;
		float x[]={1,2,3,4,5,6,7,8,9,10};
		float y[]={2.1f,4.2f,6.1f,8.1f,10.3f,12.2f,14.4f,16.1f,18.2f,20.3f};

		Point ps[]=new Point[N];
		for(int i=0;i<N;i++)
			ps[i]=new Point(x[i],y[i]);

		Line l=StatLib.linear_reg(ps);
		Point p=new Point(4,8);


		float v[]={StatLib.var(x),StatLib.cov(x,y),StatLib.pearson(x,y),l.a,l.b,l.f(4),StatLib.dev(p,l)};
		float e[]={8.25f,16.63f,0.999f,2.015f,0.113f,8.176f,0.176f};


		for(int i=0;i<7;i++)
			if(wrong(v[i],e[i]))
				System.out.println("error for check "+i+" (-14)");

		//printAll(x,y,e,l,p);
		System.out.println("done");
	}

}
