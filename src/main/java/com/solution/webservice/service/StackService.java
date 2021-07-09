package com.solution.webservice.service;

import com.solution.webservice.model.StackCustom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StackService {

  private StackCustom stack=null;
  @Value( "${stack.size}" )
  private Integer size;



  public int get(){
    if(stack==null)
      stack=new StackCustom(size);
    try{
      return stack.peek();
    }catch (Exception ex){
      throw ex;
    }


  }

  public Integer push(Integer element){
    if(stack==null)
      stack=new StackCustom(size);
    if(element==null)
      throw new IllegalArgumentException("element should not be null");
    try{
    return  stack.push(element);
    }catch (Exception ex){
      throw  ex;
    }

  }


  public Integer pop(){
    if(stack==null)
      stack=new StackCustom(size);
    return stack.pop();
  }

}
