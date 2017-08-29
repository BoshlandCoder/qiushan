package com.qiushan.tools;
/*
 * 
 * 
 * 
 * 基于沙箱进行调试
 *
 *
 */
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

public class ZhiFuInit {
	
	/*
	 * 
	 * 支付宝网关
	 * 
	 * */
	private static String URL="https://openapi.alipay.com/gateway.do";
	/*
	 * 
	 * APPID（应用ID）
	 * 
	 * 
	 * */
	private static String APP_ID="2017070207627154";  //沙箱环境
	/*
	 * 
	 * APP_PRIVATE_KEY开发者私钥，由开发者自己生成
	 * 
	 * */
	private static String APP_PRIVATE_KEY="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCnxqsOQSUGJxI1B4mxQQ9KgcPSYQHs4nnyomfxvQN/WnDeyA4Ef/1HeSJobFFo6wql3c9InhCRH3rZt9G6RjhhTovZMsRDq9ROjmd/lFUKvvSraP3u1vXE2MM7Bj96ro9iRBY8l1+qXtJw1NVWow/7pZ6c8W+r9SYzmd6lculx/p+M60rrwQzrYJX0yjkcarcexkK97cYzBKgh9ZMn9Yt9pIn1lVfrJolW4MwYcYqg86NQFWH7NEtZG5z2585UOmdCdPxqRd1YQ7zJpxme3UOJUGJPeHCtXs+X/lngY5qtsj+GVrIj+kECXHv3FRqHrLvZb3K7HRqWhocGLfgDXqGRAgMBAAECggEBAJoP4HuSboEb16hCZ7oQ2A2+4yaIVdBEl16qq3Bb9J45WnP4mIahUN8U6Pein48MZhaxe+pe2y+oDJNoLHo0iQkxq1GjQH4zhx0rvvZ0KzNW7i2Il8V+Nuivc3b74cayDJBbnV++UOaNdAiQJ+cKjV6zUtcjDTyGPLIdlUmwH5XAkfOZsDBv2CI61Y1SgObRjYNaNcw0nLcu51VPE2OEWtvYIhCy7ft8J/V1SW+j4VmUXYpdnqT7FI1ftLpzoku40fLeyI6MK+nJo7VLFUwqfRlFFpyPqBuJ31O8P9kc8aepgTd8CxZCr5LmcUy8pn1ton+OAmfE1AuVqN0sq2dDTQECgYEA0hGUc4or4gKtmXjdWH4Li0ndRxWjSweITN6VZ9M/MgOzxLxqYyufKBDezFF2G4UjXSbTNFRRBMv8TABKdlhIG3QZW4FWrs04ZOzXX04DMA4lkoFFNRFefI6p+8I+e2qIFsMfj6pkKhvz2bOkWUnXLrcYWodP95aZFg8JOlPEgEkCgYEAzHXLLZLB96HRBQ8toSCzcrte7jAQuehGk5Ek0NkLOvdrAKNounWal805w5bOKxLw7kfoPxlPfQiJF+r1Fw4oLW88zHbXauOjVl6lUFiCgiJ9UiwQzrIhUo2cXM0/14WdP8fN4dKjdLeognb4838wzm9eJc6p6kjvLMntLriTJwkCgYBmRrDkYA1liLBE3JfIEfZE5r2ZcmuCiDRQWL6dQjiufSb1Tlbt2bsvoqcXC0JZu8SwAcsq2zJnB3na9vlKDUluNGR0LNCrYrdmS/nAKRdcOkcIwW+UmtRKCJuyO6x4IjIIAxBGvkruRZXAFLqbzlu6HuL4kJDalrQKDWAMyeQOIQKBgE5FlfenZCwpvXwDWIODok783hWvPuf8vPAHM6HkRUFYsJT4+cHP/dO5VDDFTb39rVB7JLTrOpvyJZGLeDJQUB88o3je0g7wgHozF3RPvf6Vt4Y6qmCGnu0cm0yHorYeR5nAItgdrEele5QeeaW1/ng4+EDfAftX2oA5+VvWezcJAoGAMK2KSFa2SOWHTYLgx99PZdt2ognW3SEmaTEz6M//2xo4CpI8pTM599gZW9JlXhjIqNE39fb52pnziCDakqLCgj4gRBJUPHR8nEm1eU1+v5AFLzc8eV6uWx9zYGJpQMKFnJSPvlKOn1GqzIAOFB7V7EzXxXKPDYl4v4w/CwO0UmE=";
	/*
	 * 
	 * 
	 * FORMAT参数返回格式，只支持json
	 * 
	 * 
	 * */
	private static String FORMAT="json";
	/*
	 * 
	 * 
	 * CHARSET编码集，支持GBK/UTF-8
	 * 
	 * 
	 * */
	private static String CHARSET="UTF-8";
	/*
	 * 
	 * 
	 * ALIPAY_PUBLIC_KEY支付宝公钥，由支付宝生成
	 * 
	 * 
	 * */
	private static String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgKjwKz306DuN8k7NQ1z/vunGG1iSp0p2IYzazx8mBRlzPBeKRWZCVR4ZaQcPvheMJrE5dTywyzCSLAA8JFpbWg6D26gxBab4snILS1CgVJRH/R5XtCchSNJkejgczWPWGGuE36uH7hxlx/yqq/B4OOPuM99s9yG4Uy2Z95Ktk2bvBBtpwwC0E2oKimyAWmpmje+PAeYd4qmi1ezTb29EH4HMBNlTB872nk0JZRih97Mo20sEE8NatS78d46RL+WujtGiqDXE9ugPaDqbQx2f67h679SaV1Qp7qYbXgHmIQzuKe0Sqbcw5uZE1+RJ5M49Nhth3qFDkb2GGa8ilFIWNQIDAQAB";
	/*
	 * 
	 * SIGN_TYPE商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
	 *
	 */
	private static String SIGN_TYPE="RSA2";
	
	private static AlipayClient alipayClient;

	public static AlipayClient getAlipayClient() {
		if(alipayClient==null){
			alipayClient = new DefaultAlipayClient(URL,APP_ID,APP_PRIVATE_KEY,FORMAT,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);
			return alipayClient;
		}else{
			return alipayClient;
		}
	}
}	
