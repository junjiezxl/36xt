<template>
  <nav class="bg-white shadow-sm border-b border-gray-100">
    <div class="max-w-5xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between h-16">
        <div class="flex items-center">
          <router-link to="/" class="flex-shrink-0 flex items-center">
            <span class="text-xl font-bold text-gray-900 tracking-tight">36xt Blog</span>
          </router-link>
          <div class="hidden sm:ml-8 sm:flex sm:space-x-8">
            <router-link to="/" class="border-transparent text-gray-500 hover:border-gray-300 hover:text-gray-700 inline-flex items-center px-1 pt-1 border-b-2 text-sm font-medium">
              首页
            </router-link>
            <router-link to="/admin/editor" class="border-transparent text-gray-500 hover:border-gray-300 hover:text-gray-700 inline-flex items-center px-1 pt-1 border-b-2 text-sm font-medium">
              写文章
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>
