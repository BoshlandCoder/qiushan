package com.qiushan.zhifu;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.tools.ZhiFuInit;
public class PayRequest extends ActionSupport{
	
	private String order_id;
	private String price;
	private String user_id;//�����û�ID
	private String house_user; //�̼�ID
	public String getHouse_user() {
		return house_user;
	}
	public void setHouse_user(String house_user) {
		this.house_user = house_user;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("֧��");
		order_id=new SimpleDateFormat("YYYYMMddHHmmssms").format(new Date());
		System.out.println("����ӵ����"+house_user);
		String shangpinName = house_user+new SimpleDateFormat("YYYYMMdd").format(new Date())+"�׷�";
		System.out.println("�û�ID"+user_id);
		System.out.println("��Ʒ�۸�"+price);
		price=0.01+"";
		AlipayClient alipayClient=ZhiFuInit.getAlipayClient();
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		alipayRequest.setReturnUrl("http://localhost:8080/qiushan/forward.action?name=customer");
		//alipayRequest.setNotifyUrl("http://localhost:8080/qiushan/notify.action");
		alipayRequest.setBizContent("{" +
		        "    \"out_trade_no\":\""+order_id+"\"," +
		        "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
		        "    \"total_amount\":"+price+"," +
		        "    \"subject\":\""+shangpinName+"\"," +
		        "    \"body\":\""+shangpinName+"\"," +
		        "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
		        "    \"extend_params\":{" +
		        "    \"sys_service_provider_id\":\"2088511833207846\"" +
		        "    }"+
		        "  }");
		String form="";
	    try {
	        form = alipayClient.pageExecute(alipayRequest).getBody(); //����SDK���ɱ�
	    } catch (AlipayApiException e) {
	        e.printStackTrace();
	    }
	    HttpServletResponse httpResponse =ServletActionContext.getResponse();
	    httpResponse.setContentType("text/html;charset=utf-8");
	    httpResponse.getWriter().write(form);//ֱ�ӽ������ı�html�����ҳ��
	    httpResponse.getWriter().flush();
	    httpResponse.getWriter().close();
	    return super.execute();
	}
}
