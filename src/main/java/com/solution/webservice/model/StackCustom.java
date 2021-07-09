package com.solution.webservice.model;

import java.util.EmptyStackException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StackCustom {

  private int arr[];
  private int size;
  private int top;

  public StackCustom(int size) {
    this.size = size;
    arr = new int[size];
    top=-1;
  }

  private boolean isEmpty(){
    if(top==-1)
      return true;
    return false;
  }

  private boolean isFull(){
    if(top==size)
      return true;
    return false;
  }
  private int size() {
    return size;
  }

  public Integer push(int element){
    if(isFull())
      throw new StackOverflowError("Stack is full");
    top++;
    arr[top]=element;
    return arr[top];
  }

  public int pop(){
    if(isEmpty())
      throw new EmptyStackException();
    int ele= arr[top];
    top--;
    return ele;
  }

  public int peek() {
    if(!isEmpty())
      return arr[top];
    else
    {
      throw new EmptyStackException();
    }
  }


}
