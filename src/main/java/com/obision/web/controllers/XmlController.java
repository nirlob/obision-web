package com.obision.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/xml", produces = "application/xml")
public class XmlController {
    @GetMapping("/sitemap.xml")
    public ResponseEntity<String> sitemap() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        stringBuilder.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">");
        stringBuilder.append("  <url>");
        stringBuilder.append("    <loc>https://www.obision.com</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/contact</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/credits</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/documentation</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/install</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/releases</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/screenshots</loc>");
        stringBuilder.append("    <loc>https://www.obision.com/timeverse</loc>");
        stringBuilder.append("  </url>");
        stringBuilder.append("</urlset>");

        return ResponseEntity.ok(stringBuilder.toString());
    }
}
