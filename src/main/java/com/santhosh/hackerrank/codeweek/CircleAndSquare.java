package com.santhosh.hackerrank.codeweek;

import java.util.Scanner;

/**
The rectangular canvas consists of uniformly sized square pixels, and is  pixels wide, and  pixels high. Each point on the canvas belongs to a pixel, the intersection of two pixels has zero area, and each pixel is completely contained within the canvas.

The Cartesian coordinate system set up in the following way:

Point  is the center of the top-left pixel of the canvas.
Point  is the center of the top-right pixel of the canvas.
Point  is the center of the bottom-left pixel of the canvas.
Point  is the center of the bottom-right pixel of the canvas.
Thus, all pixel centers have integer coordinates and if the center of a pixel has coordinates , then point  belongs to the pixel if and only if  and . The two shapes should be drawn like so:

The circle is centered at the integer coordinates  and has non-negative integer radius . A pixel should be black as a part of the circle if and only if the Euclidean distance from the pixel's center to the center of the circle is not greater than .
image

The square is defined by the integer coordinates of two of its opposite corners  and . A pixel should be black as a part of the square if and only if its center falls within the square or along its border. The coordinates of different corners of the square do not coincide.
image

Given , , and the definition of the circle and the square, print a raster image of the canvas where each character is either a . (denoting a white pixel outside of both shapes) or a # (denoting a black pixel that's part of a shape).

Note: The first pixel of the first line of output should correspond to the top-left corner of the canvas.

Input Format

The first line contains two space-separated integers describing the respective values of  (canvas width) and (canvas height). 
The second line contains three space-separated integers describing the respective values of , , and defining a circle with radius  centered at . 
The third line contains four space-separated integers describing the respective values of  defining a square with opposite corners at  and .

Constraints

Output Format

Print  lines where each line contains  characters. Each character must be either a . (to denote a white pixel) or a # (to denote a black pixel). The first pixel of the first line of output corresponds to the top-left corner of the canvas.

Sample Input 0

20 16
9 6 5
16 14 8 14
Sample Output 0

....................
.........#..........
......#######.......
.....#########......
.....#########......
.....#########......
....###########.....
.....#########......
.....#########......
.....#########......
......#######.......
.........#.###......
..........#####.....
.........#######....
........#########...
.........#######....
Explanation 0

image

The canvas has  rows and  columns. The circle has radius  and is centered at point . The square has opposite corners located at points  and  and, as you can see, is rotated at an angle with its third corner at point  (note that its fourth corner is outside the canvas boundary). In addition, the circle and the square overlap at point .

*/
public class CircleAndSquare {
	
	
    public static boolean ifPointInsideCircle(int pointX,int pointY,int radius,int centerX,int centerY){
    	long absDistanceSquare=(((pointX-centerX)*(pointX-centerX))+((pointY-centerY)*(pointY-centerY)));
    	return ((radius*radius)>=absDistanceSquare);
    }
	public static void main(String[] args) {
		  	Scanner in = new Scanner(System.in);
	        int w = in.nextInt();
	        int h = in.nextInt();
	        int circleX = in.nextInt();
	        int circleY = in.nextInt();
	        int r = in.nextInt();
	        int x1 = in.nextInt();
	        int y1 = in.nextInt();
	        int x3 = in.nextInt();
	        int y3 = in.nextInt();
	        // your code goes here
	        for(int i=0;i<h;i++){
	        	for(int j=0;j<w;j++){
	        		if(ifPointInsideCircle(j,i, r, circleX, circleY)){
	        			System.out.print("#");
	        		}
	        		else{
	        			System.out.print(".");
	        		}
	        		
	        	}
	        	System.out.println();
	        }

	}

}
