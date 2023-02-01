object androidx {
    object core {
        private val version = "1.7.0"
        val ktx = "androidx.core:core-ktx:$version"
    }
    object compose {
        private val version = "1.1.1"
        object ui {
            val ui = "androidx.compose.ui:ui:$version"
            val preview = "androidx.compose.ui:ui-tooling-preview:$version"
            val tooling = "androidx.compose.ui:ui-tooling:$version"
            val junit = "androidx.compose.ui:ui-test-junit4:$version"
            val manifest = "androidx.compose.ui:ui-test-manifest:$version"
        }
        val material = "androidx.compose.material:material:$version"

    }
    object lifecycle {
        private val version = "2.3.1"
        val runtimektx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
    }
    object activity {
        private val version = "1.3.1"
        val activity = "androidx.activity:activity-compose:$version"
    }
    object navigation {
        private val version = "2.5.3"
        val navigation = "androidx.navigation:navigation-compose:$version"
    }
    object junit {
        private val version = "4.13.2"
        val junit = "junit:junit:$version"
    }
    object test {
        object ext {
            private val version = "1.1.5"
            val junit = "androidx.test.ext:junit:$version"
        }
        object espresso {
            private val version = "3.5.1"
            val core = "androidx.test.espresso:espresso-core:$version"
        }
    }
    object room {
        private val version = "2.5.0"
        val ktx = "androidx.room:room-ktx:$version"
        val runtime = "androidx.room:room-runtime:$version"
        val compiler = "androidx.room:room-compiler:$version"
    }
}