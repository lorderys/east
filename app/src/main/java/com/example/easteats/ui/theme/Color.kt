package com.example.easteats.ui.theme

import androidx.compose.ui.graphics.Color

val PrimaryOrange = Color(0xFFE8443A)//Base
val DarkOrange = Color(0xFFC23328) //Pressed
val LightOrange = Color(0xFFFF6B5E) //surface

val BackgroundDt = Color(0xFF000000)
val Gray50 = Color(0xFFFAFAFA)
val Gray100 = Color(0xFFEAEAEA)
val Gray200 = Color(0xFF999999)
val Gray300 = Color(0xFF888888)
val Gray400 = Color(0xFF666666)
val Black80 = Color(0xFF5A5651)

val White40 = Color(0xFFFAF8F5)
val Black40 = Color(0xFF2A2826)  //TextPrimary

val White20 = Color(0xFFFFFEFC)  //onBrand
val Black20 = Color(0xFF3D3A36)


val BackgroundLt = Color(0xFFFFFFFF)
val Black60 = Color(0xFF504D48)

val White80 = Color(0xFFEBE7E0)

val Text40 = Color(0xFFE8E6E3)

val TextTertiary = Color(0xFF9D9A95)
val TextTertiary20 = Color(0xFF888580)

val Success = Color(0xFF6B7547)
val Premium = Color(0xFFD4A574)
val Warning = Color(0xFFF4A300)
val Error  = Color(0xFFE8443A)




/*
{
    "meta": {
    "name": "Premium Restaurant App Design System",
    "version": "1.0.0",
    "platform": "Android (Material 3 / Jetpack Compose)"
},
    "color": {
    "brand": {
    "primary": {
    "value": "#E8443A",
    "type": "color",
    "description": "Main Action Buttons, Active States"
}, /
    "primaryPressed": {
    "value": "#C23328",
    "type": "color"
}, /
    "primaryLight": {
    "value": "#FF6B5E",
    "type": "color"
}, /
    "primarySurface": {
    "value": "#E8443A",
    "alpha": 0.12,
    "type": "color",
    "description": "12% Opacity for active backgrounds"
} /
},
    "semantic": {
    "background": {
    "light": "#FAF8F5",
    "dark": "#2A2826"
}, /
    "surfaceCard": {
    "light": "#FFFFFEFC",
    "dark": "#3D3A36"
}, /
    "surfaceElevated": {
    "light": "#FFFFFF",
    "dark": "#504D48"
}, /
    "divider": {
    "light": "#EBE7E0",
    "dark": "#5A5651"
} /
},
    "text": {
    "primary": {
    "light": "#2A2826",
    "dark": "#E8E6E3",
    "description": "Headlines, Dish Names"
}, /
    "secondary": {
    "light": "#6B6762",
    "dark": "#BBB8B3",
    "description": "Descriptions"
}, /
    "tertiary": {
    "light": "#9D9A95",
    "dark": "#888580",
    "description": "Metadata"
}, /
    "onBrand": {
    "value": "#FFFFFEFC",
    "description": "Text on primary buttons"
} /
},
    "functional": {
    "success": { "value": "#6B7547", "description": "Vegetarian, Available" },
    "premium": { "value": "#D4A574", "description": "Chef's Special" },
    "warning": { "value": "#F4A300", "description": "Spicy, Allergens" },
    "error": { "value": "#E8443A", "description": "Sold Out, Errors" }
} /
},

    //
    "typography": {
    "fontFamily": {
    "display": { "value": "Cormorant Garamond" },
    "body": { "value": "Manrope" }
}, /
    "styles": {
    "displayLarge": {
    "fontFamily": "{typography.fontFamily.display}",
    "weight": "Bold",
    "size": "40sp",
    "lineHeight": "48sp",
    "tracking": "-0.5sp"
}, /
    "displayMedium": {
    "fontFamily": "{typography.fontFamily.display}",
    "weight": "SemiBold",
    "size": "32sp",
    "lineHeight": "40sp",
    "tracking": "-0.25sp"
}, /
    "headlineCard": {
    "fontFamily": "{typography.fontFamily.display}",
    "weight": "SemiBold",
    "size": "22sp",
    "lineHeight": "30sp",
    "tracking": "0sp"
}, /
    "titleSection": {
    "fontFamily": "{typography.fontFamily.body}",
    "weight": "Bold",
    "size": "20sp",
    "lineHeight": "28sp",
    "tracking": "0.15sp"
}, /
    "priceLarge": {
    "fontFamily": "{typography.fontFamily.body}",
    "weight": "SemiBold",
    "size": "18sp",
    "lineHeight": "24sp",
    "tracking": "0.1sp"
}, /
    "bodyDefault": {
    "fontFamily": "{typography.fontFamily.body}",
    "weight": "Regular",
    "size": "16sp",
    "lineHeight": "24sp",
    "tracking": "0.25sp"
}, /
    "buttonLabel": {
    "fontFamily": "{typography.fontFamily.body}",
    "weight": "Bold",
    "size": "15sp",
    "lineHeight": "20sp",
    "tracking": "0.5sp"
}, /
    "metaLabel": {
    "fontFamily": "{typography.fontFamily.body}",
    "weight": "Medium",
    "size": "12sp",
    "lineHeight": "16sp",
    "tracking": "0.4sp"
} /
}
},
    //
    "shape": {
    "radius": {
    "none": { "value": "0dp" },
    "xs": { "value": "6dp" },
    "s": { "value": "12dp" },
    "m": { "value": "16dp", "usage": "Primary Buttons" },
    "l": { "value": "20dp", "usage": "Menu Cards" },
    "xl": { "value": "28dp", "usage": "Modals" }
}
},
    //
    "spacing": {
    "xxs": { "value": "4dp" },
    "xs": { "value": "8dp" },
    "s": { "value": "12dp" },
    "m": { "value": "16dp", "usage": "Screen Margin" },
    "l": { "value": "20dp" },
    "xl": { "value": "24dp" },
    "xxl": { "value": "32dp" },
    "hero": { "value": "48dp" }
},
    //
    "elevation": {
    "flat": { "dp": "0dp", "opacity": 0 },
    "card": { "dp": "1dp", "opacity": 0.08, "color": "#2A2826" },
    "float": { "dp": "4dp", "opacity": 0.12, "color": "#2A2826" },
    "modal": { "dp": "8dp", "opacity": 0.16, "color": "#2A2826" }
},
    //
    "components": {
    "button": {
    "height": "56dp",
    "radius": "{shape.radius.m}",
    "typography": "{typography.styles.buttonLabel}",
    "background": "{color.brand.primary.value}",
    "text": "{color.text.onBrand.value}"
},
    "menuCard": {
    "background": "{color.semantic.surfaceCard}",
    "radius": "{shape.radius.l}",
    "paddingHorizontal": "{spacing.l}",
    "paddingVertical": "{spacing.s}",
    "elevation": "{elevation.card}"
}
}
    //
}

*/