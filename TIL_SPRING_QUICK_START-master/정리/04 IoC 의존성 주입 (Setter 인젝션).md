# 1. Setter 인젝션 이용하기  
   
생성자 인젝션(```<constructor-arg>```)은 생성자를 이용하여 의존성을 처리한다.      
**Setter 인젝션은 Setter 메소드를 호출하여 의존성 주입을 처리하는 방법이다.**     
      
두 가지 방법 모두 멤버변수를 원하는 값으로 설정하는 것을 목적으로 하고 있고,     
결과가 같으므로 둘 중 어떤 방법을 쓰든 상관없지만     
코딩 컨벤션(관습)에 따라 한 가지로 통일해서 사용하는데 대부분은 Setter 인젝션을 사용하며,     
Setter 메소드가 제공되지 않는 클래스에 대해서만 생성자 인젝션을 사용한다.          

**즉, 우리가 자주 사용할 것은 생성자 인젝션이니 잘 외우도록 하자.**   
  
## 1.1. Setter 인젝션 기본
Setter 메소드는 스프링 컨테이너가 자동으로 호출하며, 호출하는 시점은 ```<bean>```객체 생성 직후이다.         
따라서 **Setter 인젝션이 동작하려면 Setter 메소드뿐만 아니라 기본 생성자도 반드시 필요하다.**             
   
**Setter 인젝션은 ```<property>``` 엘리먼트를 사용한다.**     
```<property>```의 ```name``` 속성 값이 호출하고자 하는 메소드 이름이다.    
```name``` 속성값이 ```"speaker"```라고 설정 되어 있으면 호출되는 메소드는 ```setSpeaker()```이다.       
여기서 중요한 점은 **name 속성의 값이 메소드의 이름과 꼭 동일해야 한다.**        
     
생성자 인젝션과 마찬가지로 Setter 메소드를 호출하면서 다른 ```<bean>``` 객체를 인자로 넘기려면     
```ref```속성을 사용하고, 기본형 데이터를 넘기려면 ```vlaue``` 속성을 사용한다.     
      
**SamsungTV**
```
package polymorphism;

public class SamsungTV implements TV {
	private Speaker speaker;
	private int price ;
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..");
	}

	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}

	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다. (가격 : "+ price +")");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}

}
```
**applicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- 클래스 지정시에 bean 태그를 사용한다. -->
	<bean id="tv" class="polymorphism.SamsungTV" init-method="initMethod" destroy-method="destroyMethod" lazy-init="true">
	  	<!-- 객체를 생성했고 거기서 Setter 메소드를 호출 이때 중요점이 이름이 같아야한다. -->
    	  	<!-- ref는 앞서 똑같이 전달할 객체의 id 를 넣고 ->
    	  	<!-- value도 앞서 똑같이 전달할 리터럴의 값을 기술해주면 된다, ->  
   		<property name="speaker" ref="apple"></property>
		<property name="price" value="2700000"></property>
	</bean>

	<bean id="sony" class="polymorphism.SonySpeaker"></bean>
	<bean id="apple" class="polymorphism.AppleSpeaker"></bean>
		
</beans>
```
**결과**
```
INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationContext.xml]
INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@39ed3c8d: startup date [Tue Oct 29 11:45:35 KST 2019]; root of context hierarchy
===> SonySpeaker 객체 생성
===> AppleSpeaker 객체 생성
===> SamsungTV 객체 생성
===> setSpeaker() 호출
===> setPrice() 호출
객체 초기화 작업 처리..
SamsungTV---전원 켠다. (가격 : 2700000)
AppleSpeaker---소리 올린다.
AppleSpeaker---소리 내린다.
SamsungTV---전원 끈다.
INFO : org.springframework.context.support.GenericXmlApplicationContext - Closing org.springframework.context.support.GenericXmlApplicationContext@39ed3c8d: startup date [Tue Oct 29 11:45:35 KST 2019]; root of context hierarchy
객체 삭제 전에 처리할 로직 처리...
```  
   
## 1.2. p 네임스페이스 사용하기   
Setter 인젝션을 설정할 때, 'p 네임스페이스'를 이용하면 좀 더 효율적으로 의존성 주입을 처리할 수 있다.          
```p 네임스페이스```는 네임스페이스에 대한 별도의 schemaLocation이 없다.         
따라서 네임스페이스만 적절히 선언하고 사용할 수 있다.        
     
**applicationContext.xml에서의 p 네임스페이스**
```
<beans ~~~
	xmlns:p="http://www.springframework.org/schema/p"
>
```
**applicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 	
	http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- 클래스 지정시에 bean 태그를 사용한다. -->
	<bean id="tv" class="polymorphism.SamsungTV" init-method="initMethod" destroy-method="destroyMethod" lazy-init="true">
		<property name="speaker" ref="apple"></property>
		<property name="price" value="2700000"></property>
	</bean>

	<bean id="sony" class="polymorphism.SonySpeaker"></bean>
	<bean id="apple" class="polymorphism.AppleSpeaker"></bean>
		
</beans>
```
```<beans>```에 p 네임스페이스를 선언했으므로   
```<bean>```태그를 닫지 않고도 ```p:변수명-ref="참조할 객체의 이름이나 아이디"```속성을 사용하여 지정할 수 있다.     
  
* p:메소드명-ref="참조할 객체의 이름이나 아이디" : setter의 매개변수로 보낼 객체 지정  
* p:메소드명="리터럴 값" : setter의 매개변수로 보낼 리터럴 정의
    
**appplicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- 클래스 지정시에 bean 태그를 사용한다. -->
	<bean id="tv" class="polymorphism.SamsungTV" 
		p:speaker-ref="sony" p:price="2700000"
		init-method="initMethod" destroy-method="destroyMethod" lazy-init="true">
	</bean>

	<bean id="sony" class="polymorphism.SonySpeaker"></bean>
	<bean id="apple" class="polymorphism.AppleSpeaker"></bean>
		
</beans>
```
이클립스에서는 STS를 활용하여 생성한 빈 클래스에서 Setter 메소드를 찾도록 만들었다.   
즉, 내가 bean에 ```setDisplay()```를 정의하면 ```p:```만 입력해도 자동 입력창에  
```p:display-ref=""``` 와 ```p:display=""``` 이 생기는 것이다.  

***
# 2 컬렉션 객체 설정  
프로그램을 개발하다 보면 데이터를 저장하는 자료구조 즉, 컬렉션 객체를 이용하는 경우가 많다.     
이때 컬렉션 객체를 의존성 주입하면 되는데, (매개변수로 컬렉션 객체를 넣어주는 것을 말한다.)    
스프링에서는 이를 위해 컬렉션 매핑과 관련된 엘리먼트를 지원한다. (xml에서 사용 가능한 컬렉션 태그를 의미)      
  
![KakaoTalk_20191029_122509599](https://user-images.githubusercontent.com/50267433/67735413-670c6b80-fa47-11e9-8bfd-ac5d64ebca2f.jpg)
  
setter 메소드를 지정하고 값을 넘겨주기 위해 사용하는   
```<property></property>``` 사이에 컬렉션에 알맞는 태그를 넣는다.  
```
java.util.List, array   :	<list><value></value></list>
java.util.Set		:	<set value-type="java.lang.String"><value></value></set>
java.util.Map		:	<map><entry><key><value></value></key><value></value></entry></map>
java.util.Properties	:	<props><prop key="키값"></prop></props>
```

## 2.1. List 타입 맵핑
배열 객체나 ```java.util.List``` 타입의 컬렉션 객체는 ```<list>``` 태그를 사용하여 설정한다.     
**CollectionBean**    
```
package com.springbook.ioc.injection;

import java.util.List;

public class CollectionBean {
	private List<String> addressList;

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	public List<String> getAddressList() {
		return addressList;
	}

}
```
**applicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean id="collectionBean" class="com.springbook.ioc.injection.CollectionBean" 
		<property name="addressList">
			<list>
				<value>서울시 강남구 역삼동</value>
				<value>서울시 성동구 행당동</value>
			</list>
		</property>
	</bean>		
</beans>
```  
메소드를 호출할 때 인자로 전달될 리스트와 그 요소를 정의한 것이다.    
       
**CollectionBeanClient(확인 코드)**     
```
package com.springbook.ioc.injection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		List<String> addressList = bean.getAddressList();
		for (String address : addressList) {
			System.out.println(address.toString());
		}
		factory.close();
	}
}
```
## 2.2. Set 타입 매핑
**중복 값을 허용하지 않는 집합 객체**를 사용할 때는 ```java.util.Set```이라는 컬렉션을 사용한다.    
    
**CollectionBean**
```
package com.springbook.ioc.injection;

import java.util.Set;

public class CollectionBean{
	private Set<String> addressList;
	
	public void setAddressList(Set<String> addressList){
		this.addressList = addressList;
	}
	
	public Set<String> getAddressList() {
		return addressList;
	}
}
```
**applicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 클래스 지정시에 bean 태그를 사용한다. -->
	<bean id="collectionBean"
		class="com.springbook.ioc.injection.CollectionBean">
		<property name="addressList">
			<set value-type="java.lang.String">
				<value>서울시 강남구 역삼동</value>
				<value>서울시 성동구 성수동</value>
				<value>서울시 성동구 성수동</value>
			</set>
		</property>
	</bean>
</beans>
```
**CollectionBeanClient(확인 코드)**     
```
package com.springbook.ioc.injection;

import java.util.List;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Set<String> addressList = bean.getAddressList();
		for (String address : addressList) {
			System.out.println(address.toString());
		}
		factory.close();
	}
}
```
위 설정을 보면 "서울시 성동구 성수동"이라는 주소가 두 번 등록된 것을 확인할 수 있다.  
그러나 Set 컬렉션은 같은 데이터를 중복해서 저장하지 않으므로 실제 실행해보면   
"서울시 성동구 성수동"이라는 주소는 하나만 저장된다.   
  
## 2.3. Map 타입 매핑
특정 Key로 데이터를 등록하고 사용할 때는 java.uti.Map 컬렉션을 사용하며, ```<map>```태그를 사용하여 설정할 수 있다.  
**CollectionBean**
```
package com.springbook.ioc.injecion;

public class CollectionBean{
	private Map<String, String> addressList;
	
	public void setAddressList(Map<String,String> addressList){
		this.addressList = addressList;
	}
}
```
**applicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 클래스 지정시에 bean 태그를 사용한다. -->
	<bean id="collectionBean"
		class="com.springbook.ioc.injection.CollectionBean">
		<property name="addressList">
			<map>
				<entry>
					<key>
						<value>고길동</value>
					</key>
					<value>서울시 강남구 역삼동</value>
				</entry>
				<entry>
					<key>
						<value>마이콜</value>
					</key>
					<value>서울시 강서구 화곡동</value>
				</entry>
			</map>
		</property>
	</bean>
</beans>
```
**CollectionBeanClient**
```
package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Map<String,String> addressList = bean.getAddressList();
		for (String address : addressList.keySet()) {
			System.out.println(address.toString());
		}
		factory.close();
	}
}
``` 
### 2.4. Properties 타입 매핑   
```key=value``` 형태의 데이터를 등록하고 사용할 때는 java.util.Properties 라는 컬렉션을 사용하며,  
```<props>``` 엘리먼트를 사용하여 설정한다. 
**CollectionBean**
```
package com.springbook.ioc.injection;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean{
	private Properties addressList;
	
	public void setAddressList(Properties addressList){
		this.addressList = addressList;
	}
	
	public Properties getAddressList() {
		return addressList;
	}
}
```
**applicationContext.xml**
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 클래스 지정시에 bean 태그를 사용한다. -->
	<bean id="collectionBean"
		class="com.springbook.ioc.injection.CollectionBean">
		<property name="addressList">
			<props>
				<prop key="고길동">서울시 강남구 역삼동</prop>
				<prop key="마이콜">서울시 강서구 화곡동</prop>
			</props>
		</property>
	</bean>
</beans>
```
**CollectionBeanClient**
```
package com.springbook.ioc.injection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("collectionBean");
		Properties addressList = bean.getAddressList();
		
		System.out.println(addressList);
		/*
		for (String address : addressList) {
			System.out.println(address.toString());
		}
		*/
		factory.close();
	}
}
```
컬렉션 매핑은 당분간 사용할 일이 없지만    
이후에 spring MVC 부분을 학습할 때 매우 자주 사용할 것이다.  
