package com.bdi.sp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.UTDAO;
import com.bdi.sp.service.UTService;
import com.bdi.sp.vo.UT;

@Service
public class UTServiceImpl implements UTService {

	@Autowired
	private UTDAO udao;
	
	@Override
	public List<UT> getUTList(UT ut) {
		// TODO Auto-generated method stub
		return udao.getUTList(ut);
	}

	@Override
	public UT getUT(Integer utnum) {
		// TODO Auto-generated method stub
		return udao.getUT(utnum);
	}

	@Override
	public int insertUT(UT ut) {
		// TODO Auto-generated method stub
		return udao.insertUT(ut);
	}

	@Override
	public int updateUT(UT ut, int utnum) {
		// TODO Auto-generated method stub
		ut.setUtnum(utnum);
		return udao.updateUT(ut);
	}

	@Override
	public int delete(int utnum) {
		// TODO Auto-generated method stub
		return udao.deleteUT(utnum);
	}

	@Override
	public Map<String, String> login(Map<String, String> ut) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg", "아이디및 비밀번호를 확인하세요");
		if(ut.get("utid")==null) {
			return rMap;
		}
		if(ut.get("utid").equals(udao.loginUT(ut).getUtid())) {
			if(ut.get("utpwd").equals(udao.loginUT(ut).getUtpwd())) {
				rMap.put("login", "success");
				rMap.put("msg", "로그인 되었습니다");
			}
		}
		return rMap;
	}

}