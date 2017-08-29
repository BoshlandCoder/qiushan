package com.qiushan.action.seller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.House;
import com.qiushan.service.SellerService;

public class UploadImage extends ActionSupport{
	private File[] image;
	private String[] imageContentType;
	private String[] imageFileName;
	private String savePath;
	private String user_id;
	private String house_id;
	private String allowTypes;
	private SellerService sellerService;
	
	
	public String getHouse_id() {
		return house_id;
	}
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	public SellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	public String getAllowTypes() {
		return allowTypes;
	}
	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}
	public File[] getImage() {
		return image;
	}
	public void setImage(File[] image) {
		this.image = image;
	}
	public String[] getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}
	public String[] getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	@Override
	public String execute() throws Exception {
		House house=(House) ActionContext.getContext().getSession().get("newHouse");
		System.out.println(image.length);
		System.out.println(getSavePath());
		System.out.println(getImageContentType()[0]);
		System.out.println(getImageFileName()[0]);
		System.out.println(allowTypes);
		String[] a = saveFile();
		sellerService.saveImage(house.getId(), a);
		int len =a.length;  //获取存了几张图片
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
 		return "success";
	}
	
	//保存图片
	public String[] saveFile() throws Exception{
		File f = new File(getSavePath()+"//"+user_id);
		String[] filename;
		if(!(f.exists())){
			f.mkdir();
		}
		if(f.exists()){
			filename = new String[image.length];
			for(int i=0;i<image.length;i++){
				filename[i]=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+Math.round(Math.random()*100)+getImageFileName()[i];
				FileOutputStream fos = new FileOutputStream(getSavePath()+"//"+user_id+"//"+filename[i]);
				FileInputStream fis = new FileInputStream(getImage()[i]);
				byte[] buff = new byte[1024];
				int len=0;
				while((len=fis.read(buff))>0){
					fos.write(buff, 0, len);
				}
			}
			return filename;
		}else{
			return null;
		}
	}
	//文件类型过滤
	public String filterType(String imageContentType,String type){
		String[] types=type.split(",");
		for(String type1:types){
			if(type1.equals(imageContentType)){
				return null;
			}
		} 
		return ERROR;
	}
	
	//验证文件类型
	@Override
	public void validate() {
		for(int i=0;i<getImageContentType().length;i++){
			String filterResult = filterType(getImageContentType()[i], getAllowTypes());
			if(filterResult!=null){
				addFieldError("image", "你要上传的文件类型不正确");
			}
		}
		super.validate();
	}
}
