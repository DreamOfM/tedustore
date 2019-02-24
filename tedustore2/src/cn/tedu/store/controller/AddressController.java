package cn.tedu.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController  {
	
	@Autowired
	private IAddressService addressService;
	
	/**
	 * 显示addressAdmin页面
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String showAddress(ModelMap modelMap,HttpSession session) {
		User user=(User) session.getAttribute("user");
		List<Address> addresses = addressService.getAllAddressByUid(user.getId());
		modelMap.addAttribute("addresses", addresses);
		return "addressAdmin";
	}
	
	/**
	 * 添加收件地址
	 * @param session
	 * @param recvName
	 * @param recvProvince
	 * @param recvCity
	 * @param recvArea
	 * @param recvAddr
	 * @param recvPhone
	 * @param recvTel
	 * @param recvZip
	 * @param recvTag
	 * @return
	 */
	@RequestMapping("/addAddress.do")
	public String add(
			HttpServletRequest request,
			HttpSession session,
			
			@RequestParam("receiverName") String recvName,
			@RequestParam(value="receiverState") String recvProvince,
			@RequestParam(value="receiverCity",required=false) String recvCity,
			@RequestParam(value="receiverDistrict",required=false) String recvArea,
			@RequestParam(value="receiverAddress",required=false) String recvAddr,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			) {
		User user=(User) session.getAttribute("user");
		Address address = new Address();
		address.setuId(user.getId());
		address.setRecvName(recvName);

   	address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		return "redirect:../address/showAddress.do";
	}
	
	/**
	 * 异步获取地址
	 * @param id
	 * @return
	 */
	/*@RequestMapping("/getAddress.do")
	@ResponseBody
	public ResponseResult<Address> getAddress(Integer id) {
		Address address = addressService.getAddressById(id);
		return new ResponseResult<Address>(1,"",address);
	}
	
	*//**
	 * 设置默认地址
	 * @param id
	 * @param session
	 * @return
	 *//*
	@RequestMapping("/setDefault.do")
	public String setDefault(Integer id, HttpSession session) {
		addressService.setDefault(id, GetUid(session));
		return "redirect:../address/showAddress.do";
	}
	
	*//**
	 * 修改收件人地址
	 * @param id
	 * @param recvName
	 * @param recvProvince
	 * @param recvCity
	 * @param recvArea
	 * @param recvAddr
	 * @param recvPhone
	 * @param recvTel
	 * @param recvZip
	 * @param recvTag
	 * @return
	 *//*
	@RequestMapping("/updateAddress.do")
	public String updateAddress(
			Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag
			) {
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		System.out.println(address);
		addressService.updateAddress(address);
		return "redirect:../address/showAddress.do";
	}
	
	*/
	@RequestMapping("/deleteAddress")
	public String deleteAddress(@RequestParam("id")Integer id) {
		System.out.println(id+"kdsjfkhkdshajfjckgjg东京分行和");
		addressService.deleteAddress(id);
		return "redirect:../address/showAddress.do";
	}
	
}
