package com.example.starter_project;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Questions extends Activity {
	
	final static int MAX_CALLS = 10;
	
	Button buttonTrue;
	Button buttonFalse;
	TextView textViewEquation;
	
	boolean result;
	int numCalls;
	
	Random random;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_questions);
		initialize();
		
		generateQuestion();
	}
	private void initialize() {
		buttonTrue = (Button) findViewById(R.id.button_true);
		buttonFalse = (Button) findViewById(R.id.button_false);
		textViewEquation = (TextView) findViewById(R.id.textView_equation);
		
		random = new Random(System.currentTimeMillis()); 
		result = false;
		numCalls = 0;
		
		buttonTrue.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						if (result) {
							generateQuestion();
						} 
					}
        });
		
		buttonFalse.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						if (!result) {
							generateQuestion();
						} 
					}
        });
		
		
		
	}
	private void generateQuestion() {
		
		if (numCalls++ == MAX_CALLS) {
			startActivity(new Intent(Questions.this, Result.class));
		}
		//Get Operands
		int num1 = random.nextInt(10);
		int num2 = random.nextInt(10);
		
		int sum = num1 + num2;
		
		//Decide on number
		int randResultSum = random.nextInt(20);
		
		System.out.printf("Before choosing\n");
		String equation = "";
		//if next random number is even; return correct result
		if (random.nextInt() % 2 == 0) {
			result = true;
			equation = String.format("%d + %d = %d", num1, num2, sum);
		} else {
			result = false;
			if (randResultSum == sum) ++randResultSum;
			equation = String.format("%d + %d = %d", num1, num2, randResultSum);
		}
		System.out.printf("Before setText\n");
		textViewEquation.setText(equation);
	}
}
