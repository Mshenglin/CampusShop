package com.xu.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopadmin")
public class ShopAdminController {
    /**
     * 店铺操作路由
     * @return
     */
    @RequestMapping(value = "shopoperation")
    public String shopOperation() {
        return "shop/shopoperation";
    }
}
