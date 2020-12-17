package com.xu.web.front;


import com.xu.entity.HeadLine;
import com.xu.entity.ShopCategory;
import com.xu.enums.EnableStatusEnum;
import com.xu.services.ShopCategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 首页控制层
 *

 */

@Controller
@RequestMapping("/front")
public class MainPageController {

	@Autowired
	private ShopCategoryService shopCategoryService;

	@Autowired
	private HeadLineService headLineService;

	/**
	 * 初始化前端展示系统的主页信息，包括获取一级店铺类别列表一级头条列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listmainpageinfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listMainPageInfo() {
		Map<String, Object> modelMap = new HashMap<>();
		List<ShopCategory> shopCategoryList = new ArrayList<>();
		try {
			// 获取一级店铺列表（即parentId为空的shopCategory）
			shopCategoryList = shopCategoryService.getShopCategoryList(null);
			modelMap.put("shopCategoryList", shopCategoryList);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}

		// 构建头条列表
		List<HeadLine> headLineList = new ArrayList<>();
		try {
			// 获取状态可用的头条列表
			HeadLine headLineCondition = new HeadLine();
			headLineCondition.setEnableStatus(EnableStatusEnum.AVAILABLE.getState());
			headLineList = headLineService.getHeadLineList(headLineCondition);
			modelMap.put("headLineList", headLineList);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		modelMap.put("success", true);
		return modelMap;
	}

}
