package com.cibil.gst.batch.entity;

import java.util.List;

public class ServiceImpl implements Service{
    private HibernateUtil hibernateUtil;
    @org.springframework.cache.annotation.Cacheable("getUserEntity")
	    public  List<UserEntity> getUserEntity(){ 
	    
	                System.out.println("Service Impl"+hibernateUtil);
	       
	        return hibernateUtil.fetchAll(UserEntity.class);
	    }

		public HibernateUtil getHibernateUtil() {
			System.out.println("************* getter "+hibernateUtil+"hhhhhhhhhhhhhh");
			return hibernateUtil;
		}

		public void setHibernateUtil(HibernateUtil hibernateUtil) {
			this.hibernateUtil = hibernateUtil;
			System.out.println("*************"+hibernateUtil.hashCode()+"hhhhhhhhhhhhhh");
			System.out.println("*************"+hibernateUtil.getSessionFactory()+"hhhhhhhhhhhhhh");
			System.out.println("*************"+hibernateUtil.getSessionFactory().hashCode()+"hhhhhhhhhhhhhh");
			
		}
	    
	    
}
